fib :: Int -> Integer
fib 0 = 0
fib 1 = 1
fib n = fib (n - 1) + fib (n - 2)

fib1 :: Int -> Integer
fib1 n = go n 0 1
  where go n x y = go (n - 1) y (x + y)

fibs :: [Integer]
fibs = 0:1:zipWith (+) fibs (tail fibs)

fib2 :: Int -> [Integer]
fib2 n = fibs !! n

array :: Ix i => (i, i) -> [(i, a)] -> Array i a
(!) :: Ix i => Array i a -> i -> a

fib3 :: Int -> Integer
fib3 n = table ! n
  where table :: Array Int Integer
        table = tabulate (0, n) memo
        memo 0 = 0
        memo 1 = 1
        memo n = table ! (n - 1) + table ! (n - 2)

distance :: String -> String -> Int
distance xs [] = length xs
distance [] ys = length ys
distance xxs@(x:xs) yys@(y:ys) = minimum [distance xxs ys + 1,
                                          distance xs yys + 1,
                                          distance xs ys + if x == y then 0 else 1]

distance :: String -> String -> Int -> Int -> Int
distance xs ys i 0 = i
distance xs ys 0 j = j
distance xs ys i j = minimum [distance xs ys i (j - 1) + 1,
                              distance xs ys (i - 1) j + 1,
                              distance xs ys (i - 1) (j - 1) + if x == y then 0 else 1]
  where m = length xs
        n = length ys
        x = xs !! i
        y = ys !! j

distance :: String -> String -> Int
distance xs ys = table ! (m, n)
  where table = tabulate ((0,0), (m,n)) memo
        memo i 0 = i
        memo 0 j = j
        memo i j = minimum [table ! (i, j - 1) + 1,
                            table ! (i - 1, j) + 1,
                            table ! (i, j) + if x == y then 0 else 1]
        m = length xs
        n = length ys
        x = xs !! i
        y = ys !! j

