import Data.List
import Data.Maybe

type Index = Int

data BExp = Prim Bool | IdRef Index | Not BExp | And BExp BExp | Or BExp BExp
            deriving (Eq, Ord, Show)

type Env = [(Index, Bool)]

type NodeId = Int

type BDDNode =  (NodeId, (Index, NodeId, NodeId))

type BDD = (NodeId, [BDDNode])

------------------------------------------------------
-- PART I

-- Pre: The item is in the given table
lookUp :: Eq a => a -> [(a, b)] -> b
lookUp item pairs
  = fromJust (lookup item pairs)

checkSat :: BDD -> Env -> Bool
checkSat (id, nodes) env
  | notElem id nodeList = id == 1
  | lookUp index env = checkSat (right, nodes) env
  | otherwise        = checkSat (left, nodes) env
     where (index, left, right) = lookUp id nodes
           nodeList = map fst nodes

sat :: BDD -> [[(Index, Bool)]]
sat bdd@(id, nodes)
  = filter (\x -> checkSat bdd x) possibles
      where vars = (nub . sort) (map (\(_, (x, _, _)) -> x) nodes)
            possibles = sequence (map (\x -> [(x, b) | b <- [True, False]]) vars)

------------------------------------------------------
-- PART II

simplify :: BExp -> BExp
simplify (Not (Prim b)) = Prim (not b)
simplify (Or (Prim a) (Prim b)) = Prim (a || b)
simplify (And (Prim a) (Prim b)) = Prim (a && b)
simplify e = e

restrict :: BExp -> Index -> Bool -> BExp
restrict (Prim b) index val = Prim b
restrict (IdRef id) index val
  | id == index = Prim val
  | otherwise   = IdRef id
restrict (Not e) index val = simplify (Not (restrict e index val))
restrict (Or e e') index val
  = simplify (Or (restrict e index val) (restrict e' index val))
restrict (And e e') index val
  = simplify (And (restrict e index val) (restrict e' index val))

------------------------------------------------------
-- PART III

-- Pre: Each variable index in the BExp appears exactly once
--     in the Index list; there are no other elements
-- The question suggests the following definition (in terms of buildBDD')
-- but you are free to implement the function differently if you wish.
buildBDD :: BExp -> [Index] -> BDD
buildBDD e xs
  = buildBDD' e 2 xs

-- Potential helper function for buildBDD which you are free
-- to define/modify/ignore/delete/embed as you see fit.
buildBDD' :: BExp -> NodeId -> [Index] -> BDD
buildBDD' bexp nodeId []
  | bexp == (Prim True) = (1, [])
  | otherwise = (0, [])
buildBDD' bexp nodeId (x : xs)
  = (nodeId, (nodeId, (x, l, r)) : leftBuild ++ rightBuild)
    where leftExp = restrict bexp x False
          rightExp = restrict bexp x True
          (l, leftBuild)  = buildBDD' leftExp (2*nodeId) xs
          (r, rightBuild) = buildBDD' rightExp (2*nodeId+1) xs

------------------------------------------------------
-- PART IV

-- Pre: Each variable index in the BExp appears exactly once
--      in the Index list; there are no other elements
buildROBDD :: BExp -> [Index] -> BDD
buildROBDD 
  = undefined

------------------------------------------------------
-- Examples for testing...

b1, b2, b3, b4, b5, b6, b7, b8 :: BExp
b1 = Prim False
b2 = Not (And (IdRef 1) (Or (Prim False) (IdRef 2)))
b3 = And (IdRef 1) (Prim True)
b4 = And (IdRef 7) (Or (IdRef 2) (Not (IdRef 3)))
b5 = Not (And (IdRef 7) (Or (IdRef 2) (Not (IdRef 3))))
b6 = Or (And (IdRef 1) (IdRef 2)) (And (IdRef 3) (IdRef 4))
b7 = Or (Not (IdRef 3)) (Or (IdRef 2) (Not (IdRef 9)))
b8 = Or (IdRef 1) (Not (IdRef 1))

bdd1, bdd2, bdd3, bdd4, bdd5, bdd6, bdd7, bdd8 :: BDD
bdd1 = (0,[])
bdd2 = (2,[(4,(2,1,1)),(5,(2,1,0)),(2,(1,4,5))])
bdd3 = (5,[(5,(1,0,1))])
bdd4 = (2,[(2,(2,4,5)),(4,(3,8,9)),(8,(7,0,1)),(9,(7,0,0)),
           (5,(3,10,11)),(10,(7,0,1)),(11,(7,0,1))])
bdd5 = (3,[(4,(3,8,9)),(3,(2,4,5)),(8,(7,1,0)),(9,(7,1,1)),
           (5,(3,10,11)),(10,(7,1,0)),(11,(7,1,0))])
bdd6 = (2,[(2,(1,4,5)),(4,(2,8,9)),(8,(3,16,17)),(16,(4,0,0)),
           (17,(4,0,1)),(9,(3,18,19)),(18,(4,0,0)),(19,(4,0,1)),
           (5,(2,10,11)),(10,(3,20,21)),(20,(4,0,0)),(21,(4,0,1)),
           (11,(3,22,23)),(22,(4,1,1)),(23,(4,1,1))])
bdd7 = (6,[(6,(2,4,5)),(4,(3,8,9)),(8,(9,1,1)),(9,(9,1,0)),
           (5,(3,10,11)),(10,(9,1,1)),(11,(9,1,1))])
bdd8 = (2,[(2,(1,1,1))])

