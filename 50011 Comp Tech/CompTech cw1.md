# Computational Techniques Coursework 1

1) Below is the proof for Q1:

Let $\bf x$ be any vector in $\R^n$, then
$$
\begin{align}
\lVert\textbf{Ax}\rVert_1&=|a_{11}x_1+a_{12}x_2+a_{13}x_3+...+a_{1n}x_n|+|a_{21}x_1+a_{22}x_2+a_{23}x_3+...+a_{2n}x_n|+...+|a_{m1}x_1+a_{m2}x_2+...+a_{mn}x_n|\\
&=\sum_{i=1}^{m}|\sum_{j=1}^{n}(a_{ij}\cdot x_j)|\le \sum_{i=1}^{m}\sum_{j=1}^{n}|a_{ij}\cdot x_j|\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \text{(due to triangular inequality: $|a+b|\le |a|+|b|$ for any $a, b\in\R$)}
\end{align}
$$

$$
\begin{align}
\sum_{i=1}^{m}\sum_{j=1}^{n}|a_{ij}\cdot x_j|&= \sum_{i=1}^{m}\sum_{j=1}^{n}|a_{ij}|| x_j| \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \text{(due to the fact that $|ab|=|a||b|$ for any $a, b\in \R$)}\\
&=|a_{11}||x_1|+|a_{12}||x_2|+...+|a_{21}||x_1|+|a_{22}||x_2|+...+|a_{mn}||x_n|\\
&=|x_1|(|a_{11}|+|a_{21}|+|a_{31}|+...+|a_{m1}|)+|x_2|(|a_{12}|+|a_{22}|+a_{32}+...+|a_{m2}|)+...+|x_n|(|a_{1n}|+...+|a_{mn}|)\\
&=\sum_{j=1}^{n}|x_j|(\sum_{i=1}^{m}|a_{ij}|)=\sum_{j=1}^{n}(\sum_{i=1}^{m}|a_{ij}|)|x_j|
\end{align}
$$

which has proved that $\lVert\textbf{Ax}\rVert_1\le \sum_{j=1}^{n}(\sum_{i=1}^{m}|a_{ij}|)|x_j|$for all $\textbf{x}\in \R^n$

2) Let $\bf x$ be any nonzero vector in $\R^n$, then
$$
\begin{align}
\lVert \textbf{A} \rVert_1&=\max_{1\le j\le n}\sum_{i=1}^{m}|a_{ij}|\\
\lVert \textbf{x} \rVert_1&=\sum_{i=1}^{n}|x_i|\\
\lVert\textbf{Ax}\rVert_1&=\sum_{i=1}^{m}|\sum_{j=1}^{n}(a_{ij}\cdot x_j)|
\end{align}
$$
Let $k$th column be the one with maximum absolute column sum in the matrix $\textbf{A}$, then
$$
\begin{align}
\lVert\textbf{A}\rVert_1&=\sum_{i=1}^{m}|a_{ik}|\\
\lVert\textbf{Ax}\rVert_1&\le \sum_{j=1}^{n}(\sum_{i=1}^{m}|a_{ij}|)|x_j| \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \  \text{(From Q1)}\\
&=|x_1|(|a_{11}|+|a_{21}|+|a_{31}|+...+|a_{m1}|)+|x_2|(|a_{12}|+|a_{22}|+a_{32}+...+|a_{m2}|)+...+|x_n|(|a_{1n}|+...+|a_{mn}|)\\
&\le |x_1|(|a_{1k}|+|a_{2k}|+|a_{3k}|+...+|a_{mk}|)+|x_2|(|a_{1k}|+|a_{2k}|+a_{3k}+...+|a_{m2}|)+...+|x_n|(|a_{1k}|+...+|a_{mk}|)\\
&\ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \ \text{(due to the fact that the sum of $k$th column is bigger than or equal to any other column)} \\
&=(\sum_{i=1}^{n}|x_i|)(\sum_{i=1}^{m}|a_{ik}|)=\lVert\textbf{x}\rVert_1\lVert\textbf{A}\rVert_1=\lVert\textbf{A}\rVert_1\lVert\textbf{x}\rVert_1
\end{align}
$$
 Therefore, $\lVert\textbf{Ax}\rVert_1\le \lVert\textbf{A}\rVert_1\lVert\textbf{x}\rVert_1$ and that $\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}\le \lVert\textbf{A}\rVert_1$ for all nonzero vectors $\textbf{x}\in \R^n$.

3) Let $k$th column of matrix $\textbf{A}$ be the one with the maximum absolute column sum, and then we construct a nonzero vector $\textbf{x}\in \R^n$ such that
$$
x_k=c, \text{where }c\in \R\\
x_i=0, \text{where }i\ne k, 1\le i\le n
$$
Then we know that
$$
\lVert\textbf{x}\rVert_1=\sum_{i=1}^{n}|x_i|=c
$$
Since only $x_k=c$ and other entries are all zero, we know that $\textbf{Ax}$ will be the column vector of $k$th column of $\textbf{A}$ with each entry multiplied by $c$. Hence, $\lVert\textbf{Ax}\rVert_1=\max_{1\le j\le n}\sum_{i=1}^{m}|a_{ij}\cdot x_j|=|x_k|\sum_{i=1}^{m}|a_{ik}|=c\sum_{i=1}^{m}|a_{ik}|=c\lVert\textbf{A}\rVert_1$. Therefore, we have:
$$
\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}=\frac{c\lVert\textbf{A}\rVert_1}{c}=\lVert\textbf{A}\rVert_1
$$
From 2) we know that for all nonzero $\textbf{x}\in \R^n$, $\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}\le \lVert\textbf{A}\rVert_1$. Therefore, the equality above holds only for certain vectors $\textbf{x}\in \R^n$. Hence, $\lVert\textbf{A}\rVert_1=\max_{\textbf{x}\ne 0}\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}$.

4) The second equality can be proved by letting $c=1$ in the proof shown in 3).

Same as in question 3), we construct a nonzero vector $\textbf{x}\in \R^n$ with $x_k=1$ and all other entries being $0$, where the $k$th column of matrix $\textbf{A}$ is the column with the maximum absolute column sum.

Then we know that
$$
\lVert\textbf{x}\rVert_1=\sum_{i=1}^{n}|x_i|=1
$$
Same as in question 3), we have
$$
\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}=\lVert\textbf{Ax}\rVert_1=\lVert\textbf{A}\rVert_1=\max_{\textbf{x}\ne 0}\frac{\lVert\textbf{Ax}\rVert_1}{\lVert\textbf{x}\rVert_1}
$$
In this case, $\lVert\textbf{Ax}\rVert_1(\text{with c = 1})=\max_{\lVert\textbf{x}\rVert_1=1}\lVert\textbf{Ax}\rVert_1$, since if we set another entry of $\textbf{x}$ to 1 and all others to 0, then it will not produce the column with maximum column sum of $\textbf{A}$, which will make the value smaller than $\lVert\textbf{A}\rVert_1$.

We have proved the second equality.

