data DList a = DList ([a] -> [a])

toList :: DList a -> [a]
toList (DList fxs) = fxs []

fromList :: [a] -> DList a
fromList xs = DList (\ys -> xs ++ ys)

class List list where
    toList :: List a -> [a]
    fromList :: [a] -> List a
    
    empty :: List a
    cons :: a -> List a -> List a
    snoc :: List a -> a -> List a

    head :: List a -> a
    tail :: List a -> List a
    init :: List a -> List a
    last :: List a -> a

data Deque a = Deque [a] [a]

instance List Deque where
    toList :: Deque a -> [a]
    toList (Deque xs ys) = xs ++ (reverse ys)

    fromList :: [a] -> Deque a
    fromList l = Deque xs sy
      where (xs, ys) = splitAt (n `div` 2) l
            n = length l
            sy = reverse ys