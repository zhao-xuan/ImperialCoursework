# 2019 Algorithm II Examination Solution(Only relevant solutions)

1. a. i) The statement is false. We only know that $f(n)=O(g(n))\Rightarrow \lim_{n\rightarrow \infin}\frac{f(n)}{g(n)}<\infin$. But if we have $2^{f(n)}=O(2^{g(n)})$, we must prove that $\lim_{n\rightarrow \infin}\frac{2^{f(n)}}{2^{g(n)}}<\infin\Rightarrow \lim_{n\rightarrow \infin}2^{f(n)-g(n)}<\infin$. We can easily come up with a counterexample: consider $f(n)=n^2+n$ and $g(n)=n^2$ which will satisfy $f(n)=O(g(n))$ but will not satisfy $2^{f(n)}=O(2^{g(n)})$

   ​	ii) The statement is true. The $\Theta$ notation indicates that the complexity of the algorithm is bounded within the exact same growth rate with the given function. In this case, $n^2$ is faster than $2^n$

   ​	iii) The statement is true. We can find median by repeatedly choosing a random number $n$ and partition the list with first half being $>n$ and second half being $<n$, then use the relative size information to find which partition contains the median. The worst case happens when we select a bordering number each time, which results in time complexity $O(n)$

   ​	iv) The statement is true. The maximum number of attempts of adding an edge in a graph is $m$, hence the worst time complexity is $m$

   ​	v) **not relevant**

   b. We need to find a $g$ such that $0<\lim_{n\rightarrow \infin}\frac{T(n)}{g(n)}<\infin$.