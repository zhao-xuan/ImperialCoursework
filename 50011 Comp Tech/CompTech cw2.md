# Computational Techniques Assessed CW2

### Solution 1

i) Since $\textbf{v}$ is an eigenvector of $\textbf{A}^T\textbf{A}$, we have
$$
(\textbf{A}^T\textbf{A})\textbf{v}=\lambda \textbf{v}, \lambda \ne 0
$$
​	We then multiply $\textbf{A}$ to both sides
$$
\begin{align}
\textbf{A}(\textbf{A}^T\textbf{A})\textbf{v}&=\lambda \textbf{A}\textbf{v}\\
(\textbf{A}\textbf{A}^T)(\textbf{Av})&=\lambda \textbf{A}\textbf{v}
\end{align}
$$
​	Hence $\textbf{Av}$ is an eigenvector of $\textbf{AA}^T$ with the same eigenvalue $\lambda\ne 0$.

ii) We need to prove that $\textbf{Av}$ is not an eigenvector of $\textbf{AA}^T$ if $\textbf{v}$ is an eigenvector of $\textbf{A}^T\textbf{A}$ when $\lambda =0$. We will prove this by showing a counterexample.

​	If $\lambda =0$, we have
$$
(\textbf{A}^T\textbf{A})\textbf{v}=\textbf{0}
$$
​	We then multiply $\textbf{v}^T$ to both sides of the equation
$$
\begin{align}
\textbf{v}^T(\textbf{A}^T\textbf{A})\textbf{v}&=\textbf{0}\\
\textbf{v}^T\textbf{A}^T\textbf{Av}&=\textbf{0}\\
(\textbf{Av})^T(\textbf{Av})&=\textbf{0}
\end{align}
$$
​	The equation above thus implies that $\textbf{Av}$ is the zero vector. Thus the statement in i) is false when $\lambda =0$.

iii) Since $\textbf{v}_1$ and $\textbf{v}_2$ are orthogonal eigenvectors, we have
$$
\textbf{v}_1\cdot\textbf{v}_2=0\\
\textbf{A}^T\textbf{A}\cdot \textbf{v}_1=\lambda_1\textbf{v}_1\\
\textbf{A}^T\textbf{A}\cdot \textbf{v}_2=\lambda_2\textbf{v}_2
$$
​	From i) we know that $\textbf{Av}_1$ is an eigenvector of $\textbf{AA}^T$ with the same eigenvalue $\lambda_1$ and $\textbf{Av}_2$ is an eigenvector of $\textbf{AA}^T$ with the same eigenvalue $\lambda_2$. Thus we have
$$
\begin{align}
(\textbf{AA}^T)(\textbf{Av}_1)&=\lambda_1\textbf{v}_1 & (1)\\
(\textbf{AA}^T)(\textbf{Av}_2)&=\lambda_2\textbf{v}_2 & (2)\\
\end{align}
$$
​	We then multiply both sides of $(1)$ by both sides of $(2)$
$$
\begin{align}
(\textbf{AA}^T)(\textbf{Av}_1)\cdot (\textbf{AA}^T)(\textbf{Av}_2)&=\lambda_1\textbf{v}_1\cdot \lambda_2\textbf{v}_2\\
\textbf{A}(\textbf{A}^T\textbf{A}\textbf{v}_1)\cdot\textbf{A}(\textbf{A}^T\textbf{A}\textbf{v}_2) &= \lambda_1\lambda_2(\textbf{v}_1\cdot \textbf{v}_2)\\
\lambda_1\textbf{A}\textbf{v}_1\cdot \lambda_2\textbf{A}\textbf{v}_2&=\lambda_1\lambda_2(\textbf{v}_1\cdot \textbf{v}_2)\\
\textbf{A}\textbf{v}_1\cdot \textbf{A}\textbf{v}_2&=0
\end{align}
$$
​	Hence, $\textbf{Av}_1$ and $\textbf{Av}_2$ are orthogonal.

iv) If $\textbf{v}_1$ and $\textbf{v}_2$ are orthogonal eigenvectors of $\textbf{AA}^T$, then $\textbf{A$^T$v}_1$ and $\textbf{A$^T$v}_2$ are orthogonal.

​	We need to prove this statement.

​	Since $\textbf{v}_1$ and $\textbf{v}_2$ are orthogonal eigenvectors, we have
$$
\textbf{v}_1\cdot\textbf{v}_2=0\\
\textbf{AA}^T\cdot \textbf{v}_1=\lambda_1\textbf{v}_1\\
\textbf{AA}^T\cdot \textbf{v}_2=\lambda_2\textbf{v}_2
$$
​	From i) we know that $\textbf{Av}_1$ and $\textbf{Av}_2$ are eigenvectors of $\textbf{A}^T\textbf{A}$ with the same eigenvalues of $\lambda_1$ and $\lambda_2$, respectively. Thus we have
$$
\begin{align}
(\textbf{A$^T$A})(\textbf{A$^T$v}_1)&=\lambda_1\textbf{v}_1 & (1)\\
(\textbf{A$^T$A})(\textbf{A$^T$v}_2)&=\lambda_2\textbf{v}_2 & (2)\\
\end{align}
$$
​	We then multiply both sides of $(1)$ by both sides of $(2)$
$$
\begin{align}
(\textbf{A$^T$A})(\textbf{A$^T$v}_1)\cdot (\textbf{A$^T$A})(\textbf{A$^T$v}_2)&=\lambda_1\textbf{v}_1\cdot \lambda_2\textbf{v}_2\\
\textbf{A}^T(\textbf{AA$^T$v$_1$})\cdot \textbf{A}^T(\textbf{AA$^T$v}_2)&=\lambda_1\textbf{v}_1\cdot \lambda_2\textbf{v}_2\\
\lambda_1\textbf{A}^T\textbf{v}_1\cdot \lambda_2\textbf{A}^T\textbf{v}_2&=\lambda_1\textbf{v}_1\cdot \lambda_2\textbf{v}_2\\
\textbf{A}^T\textbf{v}_1\cdot\textbf{A}^T\textbf{v}_2&=0
\end{align}
$$
​	Hence we have proved the statement above.

v) From i) we know that for every non-zero eigenvalue $\lambda$ of $\textbf{A$^T$A}$ and corresponding eigenvector $\textbf{v}$, we can find the eigenvector $\textbf{Av}$ of $\textbf{AA}^T$ with the same eigenvalue $\lambda$. Similarly, for every non-zero eigenvalue $\lambda$ of $\textbf{AA}^T$ (this can be regarded as $(\textbf{A$^T$})^T\textbf{A}^T$) and corresponding eigenvector $\textbf{v}$, we can find the eigenvector $\textbf{Av}$ of $\textbf{A$^T$A}$ with the same eigenvalue $\lambda$. This implies that $\textbf{A$^T$A}$ and $\textbf{AA}^T$ have the same set of non-zero eigenvalues.

​	We can further prove this by a simple contradiction: assume that $\textbf{A$^T$A}$ has an eigenvalue $\lambda$ with corresponding eigenvector $v$ that is not belong to the set of eigenvalues of $\textbf{AA}^T$. From i), we can get an eigenvector $\textbf{Av}$ of $\textbf{AA}^T$ whose eigenvalue is the same as $\lambda$, which contradicts with our assumption.

### Solution 2

i) We first calculate $\textbf{B}$
$$
\textbf{B}=\textbf{A$^T$A}=\begin{bmatrix}
3 & 1 & 1\\
-1 & 3 & 1
\end{bmatrix}\begin{bmatrix}
3 & -1\\
1 & 3\\
1 & 1
\end{bmatrix}=\begin{bmatrix}
11 & 1\\
1 & 11
\end{bmatrix}
$$
​	We first obtain the eigenvalues of $\textbf{B}$. In order to do this, we need to find all non-zero solutions of the following equation
$$
(\textbf{B}-\lambda\textbf{I})\textbf{x}=\textbf{0}
$$
​	which is equivalent to find the value of $\lambda$ in $\det(\textbf{B}-\lambda\textbf{I})=0$. The process is as follows
$$
\begin{align}
\begin{bmatrix}
11-\lambda & 1\\
1 & 11-\lambda
\end{bmatrix}&=0\\
(11-\lambda)^2-1&=0\\
(11-\lambda)^2&=1\\
\lambda &= 10, 12
\end{align}
$$
​	Then we need to find the eigenvectors by using the eigenvalues above and substitute into the equation $(\textbf{B}-\lambda\textbf{I})\textbf{x}=\textbf{0}$.
$$
\begin{align}
(\textbf{B}-10\textbf{I})\textbf{x}&=\textbf{0}\\
\begin{bmatrix}
1 & 1\\
1 & 1
\end{bmatrix}\textbf{x}&=\textbf{0}\\
E_{10}=\textbf{x}&=\begin{bmatrix}
1\\
-1
\end{bmatrix}
\end{align}
$$

$$
\begin{align}
(\textbf{B}-12\textbf{I})\textbf{x}&=\textbf{0}\\
\begin{bmatrix}
-1 & 1\\
1 & -1
\end{bmatrix}\textbf{x}&=\textbf{0}\\
E_{12}=\textbf{x}&=\begin{bmatrix}
1\\
1
\end{bmatrix}
\end{align}
$$

ii) From the properties we have obtained in Problem 1, we can now directly get the eigenvalues of $\textbf{C}$, which is the same as $\textbf{B}$: $\lambda=10,12$.

​	The corresponding eigenvectors can be obtained as described in Problem 1 i):
$$
E_{10}=\begin{bmatrix}
3 & -1\\
1 & 3\\
1 & 1
\end{bmatrix}\begin{bmatrix}
1\\
-1
\end{bmatrix}=\begin{bmatrix}
4\\
-2\\
0
\end{bmatrix}
$$

$$
E_{12}=\begin{bmatrix}
3 & -1\\
1 & 3\\
1 & 1
\end{bmatrix}\begin{bmatrix}
1\\
1
\end{bmatrix}=\begin{bmatrix}
2\\
4\\
2
\end{bmatrix}
$$

iii)  Since $\textbf{B}$ is a symmetric matrix, we can obtain a orthonormal set of eigenvectors as shown below. We can directly obtain $\textbf{Q}$ by using the eigenvectors computed above
$$
\textbf{Q}=\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & 1\\
-1 & 1
\end{bmatrix}
$$
 	By the fact that for any symmetric matrix $\textbf{M}$, $\textbf{M}^{-1}=\textbf{M}^T$, we can easily obtain $\textbf{Q}^{-1}$:
$$
\textbf{Q}^{-1}=\textbf{Q}^{T}=\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & -1\\
1 & 1
\end{bmatrix}
$$
​	 Now, we can compute $\Lambda = \textbf{Q$^T$BQ}$:
$$
\Lambda=\textbf{Q$^T$BQ}=(\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & -1\\
1 & 1
\end{bmatrix})
\begin{bmatrix}
11 & 1\\
1 & 11
\end{bmatrix}(
\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & 1\\
-1 & 1
\end{bmatrix})=
\frac{1}{2}\begin{bmatrix}
10 & -10\\
12 & 12
\end{bmatrix}\begin{bmatrix}
1 & 1\\
-1 & 1
\end{bmatrix}=
\begin{bmatrix}
10 & 0\\
0 & 12
\end{bmatrix}
$$
