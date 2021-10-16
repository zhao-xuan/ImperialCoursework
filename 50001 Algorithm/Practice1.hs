msort :: [Int] -> [Int]
msort [] = []
msort [x] = [x]
msort xs = merge (msort us) (msort vs)
  where (us, vs) = splitAt (n `div` 2) xs
        n = length xs

merge :: [Int] -> [Int] -> [Int]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys)
  | x <= y    = x : merge xs (y:ys)
  | otherwise = y : merge (x:xs) ys

qsort :: [Int] -> [Int]
qsort [] = []
qsort [x] = [x]
qsort (x:xs) = qsort us ++ [x] ++ qsort vs
  where (us, vs) = partition (<x) xs

partition :: (a -> Bool) -> [a] -> ([a], [a])
partition p xs = (filter p xs, filter (not p) xs)

length :: [a] -> Int
length []     = 0
length (x:xs) = 1 + length xs