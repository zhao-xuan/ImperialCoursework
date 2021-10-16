# Computational Techniques Assessed CW3

### Solution 1

Let $\textbf{A}=\textbf{USV}^T$, where $\textbf{U}\in \R^{2\times2}$ and $\textbf{V}\in \R^{3\times3}$ and both are orthogonal matrices.

We can obtain $\textbf{V}$ by finding the eigenvectors of $\textbf{A$^T$A}$, which together will form an orthogonal matrix of $\textbf{A$^T$A}$.

We first find the matrix $\textbf{AA}^T$ since its dimension is smaller than $\textbf{A$^T$A}$
$$
\textbf{AA}^T=
\begin{bmatrix}
3 & 2 & 2\\
2 & 3 & -2
\end{bmatrix}\begin{bmatrix}
3 & 2\\
2 & 3\\
2 & -2
\end{bmatrix}=\begin{bmatrix}
17 & 8\\
8 & 17
\end{bmatrix}
$$
The eigenvalues of $\textbf{AA}^T$ can be found by solving $\det(\textbf{AA}^T-\lambda\textbf{I})=0$
$$
\begin{align}
\det\left(\begin{bmatrix}
17-\lambda & 8\\
8 & 17-\lambda
\end{bmatrix}\right)&=0\\
\left\lvert
\begin{matrix}
17-\lambda & 8\\
8 & 17-\lambda
\end{matrix}
\right\rvert&=0\\
(17-\lambda)^2-8^2&=0\\
(17-\lambda)^2&=8^2\\
\lambda&=9,25

\end{align}
$$
We then find the eigenvectors of matrix $\textbf{A$^T$A}$ corresponding to these eigenvalues
$$
\begin{align}
(\textbf{AA}^T-9\textbf{I})\textbf{x}&=0\\
\begin{bmatrix}
8 & 8\\
8 & 8
\end{bmatrix}\textbf{x}&=0\\
\textbf{x}&=\text{span}\left(\begin{bmatrix}
1\\
-1
\end{bmatrix}\right)\\
E_9&=\frac{1}{\sqrt{2}}\begin{bmatrix}
1\\-1
\end{bmatrix}
\end{align}
$$

$$
\begin{align}
(\textbf{AA}^T-25\textbf{I})\textbf{x}&=0\\
\begin{bmatrix}
-8 & 8\\
8 & -8
\end{bmatrix}\textbf{x}&=0\\
\textbf{x}&=\text{span}\left(\begin{bmatrix}
1\\1
\end{bmatrix}\right)\\
E_{25}&=\frac{1}{\sqrt{2}}\begin{bmatrix}
1\\1
\end{bmatrix}
\end{align}
$$

We have now obtained $\textbf{U}$
$$
\textbf{U}=\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & 1\\
1 & -1
\end{bmatrix}
$$
Now we use the fact that $\textbf{US}=\textbf{AV}$ to compute $\textbf{V}$
$$
\begin{align}
\textbf{v}_1&=\frac{1}{\sigma_1}\textbf{A$^T$u}_1\\
\textbf{v}_1&=\frac{1}{5\sqrt{2}}\begin{bmatrix}
3 & 2\\
2 & 3\\
2 & -2
\end{bmatrix}\begin{bmatrix}
1\\
1
\end{bmatrix}\\
\textbf{v}_1&=\begin{bmatrix}
\frac{1}{\sqrt{2}}\\
\frac{1}{\sqrt{2}}\\
0
\end{bmatrix}
\end{align}
$$

$$
\begin{align}
\textbf{v}_2&=\frac{1}{\sigma_2}\textbf{A$^T$u}_2\\
\textbf{v}_2&=\frac{1}{3\sqrt{2}}
\begin{bmatrix}
3 & 2\\
2 & 3\\
2 & -2
\end{bmatrix}
\begin{bmatrix}
1\\-1
\end{bmatrix}
\\
\textbf{v}_2&=\begin{bmatrix}
\frac{1}{3\sqrt{2}}\\
-\frac{1}{3\sqrt{2}}\\
\frac{4}{3\sqrt{2}}
\end{bmatrix}
\end{align}
$$

We can then construct $\textbf{v}_3$ by using the following property, since $\textbf{V}$ is an orthogonal matrix
$$
\begin{align}
\textbf{v}_3&=\textbf{v}_1\times\textbf{v}_2
\end{align}
$$
By using the cross product:
$$
\textbf{v}_{3,normalized}=\textbf{v}_{1,normalized}\times\textbf{v}_{2,normalized}=\left\lvert \begin{matrix}
\textbf{i} & \textbf{j} & \textbf{k}\\
\frac{1}{\sqrt{2}} & \frac{1}{\sqrt{2}} & 0\\
\frac{1}{3\sqrt{2}} & -\frac{1}{3\sqrt{2}} & -\frac{4}{3\sqrt{2}}
\end{matrix}\right\rvert=
-\frac{2}{3}\textbf{i}+\frac{2}{3}\textbf{j}-\frac{1}{3}\textbf{k}\Rightarrow \begin{bmatrix}
-\frac{2}{3}\\
\frac{2}{3}\\
-\frac{1}{3}
\end{bmatrix}
$$
Hence we have also obtained $\textbf{V}$
$$
\textbf{V}=\begin{bmatrix}
\textbf{v}_{1,normalized} & \textbf{v}_{2,normalized} & \textbf{v}_{3,normalized}
\end{bmatrix}=\begin{bmatrix}
\frac{1}{\sqrt{2}} & \frac{1}{3\sqrt{2}} & -\frac{2}{3} \\
\frac{1}{\sqrt{2}} & -\frac{1}{3\sqrt{2}} & \frac{2}{3}\\
0 & \frac{4}{3\sqrt{2}} & -\frac{1}{3}
\end{bmatrix}
$$
and also $\textbf{S}$
$$
\textbf{S}=\begin{bmatrix}
5 & 0 & 0\\
0 & 3 & 0\\
\end{bmatrix}
$$
Therefore the singular value decomposition of $\textbf{A}$ is as follows
$$
\begin{align}
\textbf{A}=\textbf{USV}^T&=\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & 1\\
1 & -1
\end{bmatrix}\begin{bmatrix}
5 & 0 & 0\\
0 & 3 & 0\\
\end{bmatrix}\begin{bmatrix}
\frac{1}{\sqrt{2}} & \frac{1}{\sqrt{2}} & 0\\
\frac{1}{3\sqrt{2}} & -\frac{1}{3\sqrt{2}} & \frac{4}{3\sqrt{2}}\\
-\frac{2}{3} & \frac{2}{3} & -\frac{1}{3}
\end{bmatrix}\\

&=\frac{1}{\sqrt{2}}\begin{bmatrix}
1 & 1\\
1 & -1
\end{bmatrix}\begin{bmatrix}
\frac{5}{\sqrt{2}} & \frac{5}{\sqrt{2}} & 0\\
\frac{1}{\sqrt{2}} & -\frac{1}{\sqrt{2}} & \frac{4}{\sqrt{2}}\\
\end{bmatrix}\\

&=\begin{bmatrix}
1 & 1\\
1 & -1
\end{bmatrix}
\begin{bmatrix}
\frac{5}{2} & \frac{5}{2} & 0\\
\frac{1}{2} & -\frac{1}{2} & 2\\
\end{bmatrix}\\

&=\begin{bmatrix}
3 & 2 & 2\\
2 & 3 & -2
\end{bmatrix}=\textbf{A}
\end{align}
$$

### Solution 2

i) From the definition of matrix multiplication we know that
$$
\begin{align}
\textbf{BC}=\sum_{i=1}^{m}\sum_{j=1}^{n}\sum_{c=1}^{k}b_{ic}c_{cj}&=\begin{bmatrix}
b_{11}c_{11}+b_{12}c_{21}+...+b_{1k}c_{k1} & b_{11}c_{12}+b_{12}c_{22}+...+b_{1k}c_{k2} & ...\\
b_{21}c_{11}+b_{22}c_{21}+...+b_{2k}c_{k1} & b_{21}c_{12}+b_{22}c_{22}+...+b_{2k}c_{k2} & ...\\
... & ... & ...
\end{bmatrix}\\
&=\begin{bmatrix}
b_{11}c_{11} & b_{11}c_{12} & b_{11}c_{13} & ...\\
b_{21}c_{11} & b_{21}c_{12} & b_{21}c_{13} & ...\\
b_{31}c_{11} & b_{31}c_{12} & b_{31}c_{13} & ...\\
... & ... & ... & ...
\end{bmatrix} + \begin{bmatrix}
b_{12}c_{21} & b_{12}c_{22} & b_{12}c_{23} & ...\\
b_{22}c_{21} & b_{22}c_{22} & b_{22}c_{23} & ...\\
b_{32}c_{21} & b_{32}c_{22} & b_{32}c_{23} & ...\\
... & ... & ... & ...
\end{bmatrix}+...\\
&=b_1c^1+b_2c^2+b_3c^3+...+b_kc^k\\
&=\sum_{i=1}^{k}b_ic^i
\end{align}
$$
where $b_i$ denotes the $i$th column of $\textbf{B}$ and $c^i$ denotes the $i$th row of $\textbf{C}$.

ii) From the nature of singular value decomposition we know that $\textbf{S}=\text{diag($\sigma_1$, $\sigma_2$, $\sigma_3$,...,$\sigma_r$,$\sigma_{r+1}$, $\sigma_{r+2}$,...,$\sigma_{min(m,n)}$)}$ where $\sigma_{r+1}=\sigma_{r+2}=...=\sigma_{min(m,n)=0}$.

Hence we can obtain $\textbf{US}$ using the statement from i):
$$
\textbf{US}=\sum_{i=1}^{m}u_is^i
$$
where $u_i$ denotes the $i$th column of $\textbf{U}$ and $s^i$ denotes the $i$th row of $\textbf{S}$. Since only the diagonal element of $\textbf{S}$ has value $\sigma_i$ and all other entries are $0$, we know that
$$
\textbf{US}=\sum_{i=1}^{m}u_is^i=\sigma_1u_1+\sigma_2u_2+...+\sigma_mu_m=\sum_{i=1}^{m}\sigma_iu_i
$$
which means that the $i$th column of $\textbf{US}$ is $\sigma_iu_i$.

Again from i), we can then obtain $\textbf{USV}^T$
$$
\textbf{A}=\textbf{USV}^T=\textbf{US}\cdot \textbf{V}^T=\sum_{i=1}^{n}\sigma_iu_iv^i
$$
where $v^i$ denotes the $i$th row of $\textbf{V}^T$. After transpose, we know that the $i$th row of $\textbf{V}^T$ is $v^T_i$. Therefore
$$
\textbf{A}=\textbf{USV}^T=\textbf{US}\cdot \textbf{V}^T=\sum_{i=1}^{n}\sigma_iu_iv^i=\sum_{i=1}^{n}\sigma_iu_iv^T_i
$$

### Solution 3

i) We substitude $w$ with $Vx$ and let $S=\text{diag}(\sigma_1^2, \sigma_2^2, ..., \sigma_n^2)$
$$
\begin{align}
w_{(1)}&=\arg\max\{w^TA^TAw:w\in \R^n,\lVert w\rVert=1\}\\
&=\arg\max\{(Vx)^TA^TAVx:Vx\in \R^n,\lVert Vx\rVert=1\}\\
&=\arg\max\{(x^TV^TA^TAVx:Vx\in \R^n,\lVert Vx\rVert=1\}\\
&=\arg\max\{(x^TS^TSx:Vx\in \R^n,\lVert Vx\rVert=1\}\\
\end{align}
$$
​	We then expand $x^TS^TSx$:
$$
\begin{align}
x^TS^TSx&=\begin{bmatrix}
x_1 & x_2 & x_3 & ... & x_n
\end{bmatrix}\begin{bmatrix}
\sigma_1^2 & 0 & 0 & ...\\
0 & \sigma_2^2 & 0 & ...\\
0 & 0 & \sigma_3^2 & ...\\
... & ... & ... & \sigma_n^2
\end{bmatrix}\begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ ... \\ x_n
\end{bmatrix}\\
&=\begin{bmatrix}
x_1\sigma_1^2 & x_2\sigma_2^2 & x_3\sigma_3^2 & ... & x_n\sigma_n^2
\end{bmatrix}\begin{bmatrix}
x_1 \\ x_2 \\ x_3 \\ ... \\ x_n
\end{bmatrix}\\
&=x_1^2\sigma_1^2 + x_2^2\sigma_2^2 + x_3^2\sigma_3^2 + ... + x_n^2\sigma_n^2
\end{align}
$$
​	Since $\sigma_1\ge\sigma_2\ge\sigma_3\ge...\ge\sigma_n\ge 0$ and $\lVert Vx\rVert=1$, we know that the largest singular value is $\sigma_1$, therefore we can find the maximum value by setting $x_1=1$ and $x_2=x_3=...=x_n=0$. Hence, $x=\begin{bmatrix}1\\0\\0\\...\\0\end{bmatrix}$

​	We then put $x$ back into $w=Vx$ and get
$$
w=Vx=\begin{bmatrix}
v_1,v_2,...,v_n
\end{bmatrix}\begin{bmatrix}
1\\0\\0\\...\\ 0
\end{bmatrix}=v_1
$$
​	where $v_i$ denotes the $i$th column of $V$.

​	Hence, we have proved that $w_{(1)}=v_1$

ii) From i) we know that we can find a matrix $V$ such that $V^T$ gives the singular value decomposition of $A$ because of the fact that $V^TA^TAV=\text{diag}(\sigma_1^2, \sigma_2^2, \sigma_3^2,...,\sigma_n^2)$. Then, we have also shown that using $V$ we can obtain $w_{(1)}=v_1$ where $x=\begin{bmatrix}1\\0\\0\\...\end{bmatrix}$ and $w=Vx$.

​	From Problem 2 we know that if we can find a singular value decomposition $A=USV^T$, we have
$$
A=\sum_{i=1}^{r}\sigma_iu_iv_i^T=\sigma_1u_1v_1^T+\sigma_2u_2v_2^T+\sigma_3u_3v_3^T+...+\sigma_ru_rv_r^T
$$
​	where $r$ is the rank of $A$ and $U\in\R^{m\times m}$ and $V\in\R^{n\times n}$.

​	Since we represent $A$ in the direction of first principal component, $v_2=v_3=...=\textbf{0}$ as indicated in Problem 3 i). Hence, $A$ becomes only the first term in the SVD formula
$$
A≈\sigma_1u_1v_1^T
$$
