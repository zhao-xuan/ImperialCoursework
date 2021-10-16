# Computational Techniques Assessed Coursework 4

### Solution 1

a) The basis function are $f_1(t)=1$ and $f_2(t)=t$

b) The matrix $A$ is
$$
A=\begin{bmatrix}
1 & t_1\\
1 & t_2\\
1 & t_3\\
... & ...\\
1 & t_i
\end{bmatrix}
$$
c) In order to have a unique solution, $\textbf{A}^T\textbf{A}$ has to be positive definite and thus $\textbf{A}$ has to be a full-rank matrix.

​	We know that the normal equation on $\textbf{A}$ is $\textbf{A$^T$Ax}=\textbf{A}^T\textbf{b}$. Using Cholesky factorization we can find a lower triangular matrix $\textbf{L}$ such that $\textbf{A$^T$A}=\textbf{LL}^T$. If $\textbf{A$^T$A}$ is positive definite, then the Cholesky factorization is unique and therefore we can find a unique solution to $\textbf{Ly}=\textbf{A$^T$b}$ by using forward substitution to get $\textbf{y}$. Then we find a unique solution to $\textbf{L$^T$x}=\textbf{y}$ by using backward substitution. Since both forward and backward substitution generate unique solutions, we know that the solution $\textbf{x}$ is also unique.

​	Since $\textbf{A$^T$A}$ is positive definite, we know that for any $\textbf{x}\in\R^2$
$$
\begin{align}
\textbf{x$^T$A$^T$Ax}&>0\\
\textbf{$($Ax$)^T$Ax}&>0\\
\end{align}
$$
​	Therefore, it is not possible to find a non-zero solution to the equation $\textbf{Ax}=\textbf{0}$ and thus the columns of $\textbf{A}$ are linearly independent, which indicates that $\textbf{A}$ has full-rank.

​	We can then expand this ineuqality and get the 
$$
\begin{align}
\textbf{x$^T$A$^T$Ax}&>0\\

\begin{bmatrix}
x_1 & x_2
\end{bmatrix}
\begin{bmatrix}
m & \sum_{i=1}^{m}t_i\\
\sum_{i=1}^{m}t_i & \sum_{i=1}^{m}t_i^2
\end{bmatrix}
\begin{bmatrix}
x_1 \\ x_2
\end{bmatrix}&>0\\

mx_1^2+2\sum_{i=1}^{m}t_i\cdot x_1x_2+\sum_{i=1}^{m}t_i^2\cdot x_2^2&>0\\

\end{align}
$$
​	This indicates that $(2\sum_{i=1}^{m}t_i)^2-4m\sum_{i=1}^{m}t_i^2<0$. We then expand this inequality
$$
\begin{align}
(2\sum_{i=1}^{m}t_i)^2-4m\sum_{i=1}^{m}t_i^2&<0\\
4(\sum_{i=1}^{m}t_i)^2&<4m\sum_{i=1}^{m}t_i^2\\
(\sum_{i=1}^{m}t_i)^2&<m\sum_{i=1}^{m}t_i^2\\
\end{align}
$$
​	where $m$ denotes the number of rows of $\textbf{A}$, or the number of data points in $\textbf{A}$.

​	From the fact that $\textbf{A}$'s columns are linearly independent, there are at least $2$ dinstinct values of $t_i$ that are different.

d) The matrix $\textbf{A$^T$A}$ is as follows
$$
\textbf{A$^T$A}=\begin{bmatrix}
m & \sum_{i=1}^{m}t_i\\
\sum_{i=1}^{m}t_i & \sum_{i=1}^{m}t_i^2
\end{bmatrix}=\begin{bmatrix}
m & S_t\\
S_t & S_{t^2}
\end{bmatrix}
$$
e) The determinant is as follows
$$
\det(\textbf{A$^T$A})=\left\lvert\begin{matrix}
m & \sum_{i=1}^{m}t_i\\
\sum_{i=1}^{m}t_i & \sum_{i=1}^{m}t_i^2
\end{matrix}
\right\rvert=m\sum_{i=1}^{m}t_i^2-(\sum_{i=1}^{m}t_i)^2=mS_{t^2}-S_t^2
$$
​	The inverse is as follows
$$
\begin{align}
(\textbf{A$^T$A})^{-1}&=\frac{1}{\det(\textbf{A$^T$A})}\begin{bmatrix}
S_{t^2} & -S_t\\
-S_t & m
\end{bmatrix}\\
&=\begin{bmatrix}
\frac{S_{t^2}}{mS_{t^2}-S_t^2} & -\frac{S_t}{mS_{t^2}-S_t^2}\\
-\frac{S_t}{mS_{t^2}-S_t^2} & \frac{m}{mS_{t^2}-S_t^2}
\end{bmatrix}
\end{align}
$$
f) The matrix $\textbf{A$^T$b}$ is as follows
$$
\textbf{A$^T$b}=\begin{bmatrix}
1 & 1 & 1 &...&1\\
t_1 & t_2 & t_3 & ...&t_m
\end{bmatrix}\begin{bmatrix}
y_1\\y_2\\y_3\\...\\y_m
\end{bmatrix}=\begin{bmatrix}
S_y\\
S_{ty}
\end{bmatrix}
$$
g) We know that the normal equations give solution to the least square problem. Now we find the solution for $\textbf{A$^T$Ax}=\textbf{A$^T$b}$
$$
\begin{align}
\textbf{A$^T$Ax}&=\textbf{A$^T$b}\\
\textbf{x}&=(\textbf{A$^T$A})^{-1}\textbf{A}^T\textbf{b}\\
\textbf{x}&=\begin{bmatrix}
\frac{S_{t^2}}{mS_{t^2}-S_t^2} & -\frac{S_t}{mS_{t^2}-S_t^2}\\
-\frac{S_t}{mS_{t^2}-S_t^2} & \frac{m}{mS_{t^2}-S_t^2}
\end{bmatrix}\begin{bmatrix}
S_y\\
S_{ty}
\end{bmatrix}\\
\textbf{x}&=\begin{bmatrix}
\frac{S_{t^2}S_y-S_tS_{ty}}{mS_{t^2}-S_t^2}\\
\frac{mS_{ty}-S_tS_y}{mS_{t^2}-S_t^2}
\end{bmatrix}
\end{align}
$$

h) We can obtain two suitably chosen data pairs $t_1, y_1$ and $t_2, y_2$ satisfying $(1)$, which must be distinct pairs
$$
y_1=p_1+p_2t_1\\
y_2=p_1+p_2t_2
$$
​	so that
$$
\begin{align}
\textbf{x}=\begin{bmatrix}
\frac{S_{t^2}S_y-S_tS_{ty}}{mS_{t^2}-S_t^2}\\
\frac{mS_{ty}-S_tS_y}{mS_{t^2}-S_t^2}
\end{bmatrix}&=\begin{bmatrix}
\frac{(t_1^2+t_2^2)(2p_1+p_2(t_1+t_2))-(t_1+t_2)(p_1(t_1+t_2)+p_2(t_1^2+t_2^2))}{2(t_1^2+t_2^2)-(t_1+t_2)^2}\\
\frac{2(p_1(t_1+t_2)+p_2(t_1^2+t_2^2))-(t_1+t_2)(2p_1+p_2(t_1+t_2))}{2(t_1^2+t_2^2)-(t_1+t_2)^2}
\end{bmatrix}\\&=
\begin{bmatrix}
\frac{2p_1(t_1^2+t_2^2)+p_2(t_1+t_2)(t_1^2+t_2^2)-p_1(t_1+t_2)^2-p_2(t_1+t_2)(t_1^2+t_2^2)}{2t_1^2+2t_2^2-t_1^2-t_2^2-2t_1t_2}\\
\frac{2p_1(t_1+t_2)+2p_2(t_1^2+t_2^2)-2p_1(t_1+t_2)-p_2(t_1+t_2)^2}{2t_1^2+2t_2^2-t_1^2-t_2^2-2t_1t_2}
\end{bmatrix}\\
&=\begin{bmatrix}
\frac{p_1(2t_1^2+2t_2^2-(t_1+t_2)^2)}{(t_1-t_2)^2}\\
\frac{p_2(2t_1^2+2t_2^2-(t_1+t_2)^2)}{(t_1-t_2)^2}
\end{bmatrix}\\
&=\begin{bmatrix}
\frac{p_1(t_1-t_2)^2}{(t_1-t_2)^2}\\
\frac{p_2(t_1-t_2)^2}{(t_1-t_2)^2}
\end{bmatrix}\\
&=\begin{bmatrix}
p_1\\p_2
\end{bmatrix}
\end{align}
$$
​	This test works because any two points can determine a line. In other words, the solution to the following linear system is unique since that $t_1, t_2, y_1, y_2$ are known and $t_1\ne t_2$
$$
\begin{bmatrix}
1 & t_1\\
1 & t_2
\end{bmatrix}
\begin{bmatrix}
p_1\\p_2
\end{bmatrix}=
\begin{bmatrix}
y_1\\y_2
\end{bmatrix}
$$

### Solution 2

From matrix $\textbf{A}$, we know that
$$
\textbf{a}_1=\begin{bmatrix}
1\\1\\1\\1
\end{bmatrix}, 
\textbf{a}_2=\begin{bmatrix}
1\\0\\1\\0
\end{bmatrix},
\textbf{a}_3=\begin{bmatrix}
0\\0\\1\\1
\end{bmatrix},
\textbf{a}_4=\begin{bmatrix}
1\\1\\1\\0
\end{bmatrix}
$$
We can directly set $\textbf{u}_1=\textbf{a}_1$ and then compute $\textbf{e}_1=\frac{\textbf{u}_1}{\lVert\textbf{u}_1\rVert}$
$$
\textbf{e}_1=\begin{bmatrix}
\frac{1}{2}\\
\frac{1}{2}\\
\frac{1}{2}\\
\frac{1}{2}
\end{bmatrix},\textbf{e}_1\cdot \textbf{a}_1=2, \textbf{e}_1\cdot \textbf{a}_2=1, \textbf{e}_1\cdot \textbf{a}_3=1, \textbf{e}_1\cdot \textbf{e}_4=\frac{3}{2}
$$
Then we can obtain $\textbf{u}_2=\textbf{a}_2-(\textbf{e}_1\cdot \textbf{a}_2)\textbf{e}_1$
$$
\textbf{u}_2=\textbf{a}_2-(\textbf{e}_1\cdot \textbf{a}_2)\textbf{e}_1=\begin{bmatrix}
1-\frac{1}{2}\\
0-\frac{1}{2}\\
1-\frac{1}{2}\\
0-\frac{1}{2}
\end{bmatrix}=\begin{bmatrix}
\frac{1}{2}\\
-\frac{1}{2}\\
\frac{1}{2}\\
-\frac{1}{2}
\end{bmatrix}
$$
Again, we can compute $\textbf{e}_2=\frac{\textbf{u}_2}{\lVert\textbf{u}_2\rVert}$
$$
\textbf{e}_2=\begin{bmatrix}
\frac{1}{2}\\
-\frac{1}{2}\\
\frac{1}{2}\\
-\frac{1}{2}
\end{bmatrix},
\textbf{e}_2\cdot\textbf{a}_2=1,\textbf{e}_2\cdot \textbf{a}_3=0, \textbf{e}_2\cdot \textbf{a}_4=\frac{1}{2}
$$
Then we can obtain $\textbf{u}_3=\textbf{a}_3-(\textbf{e}_1\cdot \textbf{a}_3)\textbf{e}_1-(\textbf{e}_2\cdot\textbf{a}_3)\textbf{e}_2$
$$
\textbf{u}_3=\begin{bmatrix}
0-\frac{1}{2}\\
0-\frac{1}{2}\\
1-\frac{1}{2}\\
1-\frac{1}{2}
\end{bmatrix}=\begin{bmatrix}
-\frac{1}{2}\\
-\frac{1}{2}\\
\frac{1}{2}\\
\frac{1}{2}
\end{bmatrix}
$$
Again, we can compute $\textbf{e}_3=\frac{\textbf{u}_3}{\lVert\textbf{u}_3\rVert}$
$$
\textbf{e}_3=\begin{bmatrix}
-\frac{1}{2}\\
-\frac{1}{2}\\
\frac{1}{2}\\
\frac{1}{2}
\end{bmatrix},
\textbf{e}_3\cdot\textbf{a}_3=1, \textbf{e}_3\cdot\textbf{a}_4=-\frac{1}{2}
$$
Then we can obtain $\textbf{u}_4=\textbf{a}_4-(\textbf{e}_1\cdot \textbf{a}_4)\textbf{e}_1-(\textbf{e}_2\cdot \textbf{a}_4)\textbf{e}_2-(\textbf{e}_3\cdot \textbf{a}_4)\textbf{e}_3$
$$
\textbf{u}_4=\begin{bmatrix}
1-\frac{3}{4}-\frac{1}{4}-\frac{1}{4}\\
1-\frac{3}{4}+\frac{1}{4}-\frac{1}{4}\\
1-\frac{3}{4}-\frac{1}{4}+\frac{1}{4}\\
0-\frac{3}{4}+\frac{1}{4}+\frac{1}{4}
\end{bmatrix}=\begin{bmatrix}
-\frac{1}{4}\\
\frac{1}{4}\\
\frac{1}{4}\\
-\frac{1}{4}
\end{bmatrix}
$$
Again, we can compute $\textbf{e}_4=\frac{\textbf{u}_4}{\lVert\textbf{u}_4\rVert}$
$$
\textbf{e}_4=\begin{bmatrix}
-\frac{1}{2}\\
\frac{1}{2}\\
\frac{1}{2}\\
-\frac{1}{2}
\end{bmatrix}, \textbf{e}_4\cdot\textbf{a}_4=\frac{1}{2}
$$
Then we can put $\textbf{Q}=\begin{bmatrix}\textbf{e}_1&\textbf{e}_2&\textbf{e}_3&\textbf{e}_4\end{bmatrix}$
$$
\textbf{Q}=\begin{bmatrix}
\frac{1}{2} & \frac{1}{2} & -\frac{1}{2} & -\frac{1}{2}\\
\frac{1}{2} & -\frac{1}{2} & -\frac{1}{2} & \frac{1}{2}\\
\frac{1}{2} & \frac{1}{2} & \frac{1}{2} & \frac{1}{2}\\
\frac{1}{2} & -\frac{1}{2} & \frac{1}{2} & -\frac{1}{2}
\end{bmatrix}
$$
and $\textbf{R}$ as follows
$$
\textbf{R}=\begin{bmatrix}
\textbf{e}_1\cdot\textbf{a}_1 & \textbf{e}_1\cdot\textbf{a}_2 & \textbf{e}_1\cdot\textbf{a}_3 & \textbf{e}_1\cdot\textbf{a}_4\\
0 & \textbf{e}_2\cdot\textbf{a}_2 & \textbf{e}_2\cdot\textbf{a}_3 & \textbf{e}_2\cdot\textbf{a}_4\\
0 & 0 & \textbf{e}_3\cdot\textbf{a}_3 & \textbf{e}_3\cdot\textbf{a}_4\\
0 & 0 & 0 & \textbf{e}_4\cdot\textbf{a}_4
\end{bmatrix}=\begin{bmatrix}
2 & 1 & 1 & \frac{3}{2}\\
0 & 1 & 0 & \frac{1}{2}\\
0 & 0 & 1 & -\frac{1}{2}\\
0 & 0 & 0 & \frac{1}{2}
\end{bmatrix}
$$
we can also verify that
$$
\begin{align}
\textbf{QR}&=\begin{bmatrix}
\frac{1}{2} & \frac{1}{2} & -\frac{1}{2} & -\frac{1}{2}\\
\frac{1}{2} & -\frac{1}{2} & -\frac{1}{2} & \frac{1}{2}\\
\frac{1}{2} & \frac{1}{2} & \frac{1}{2} & \frac{1}{2}\\
\frac{1}{2} & -\frac{1}{2} & \frac{1}{2} & -\frac{1}{2}
\end{bmatrix}\begin{bmatrix}
2 & 1 & 1 & \frac{3}{2}\\
0 & 1 & 0 & \frac{1}{2}\\
0 & 0 & 1 & -\frac{1}{2}\\
0 & 0 & 0 & \frac{1}{2}
\end{bmatrix}\\&=\begin{bmatrix}
1 & 1 & 0 & 1\\
1 & 0 & 0 & 1\\
1 & 1 & 1 & 1\\
1 & 0 & 1 & 0
\end{bmatrix}=\textbf{A}
\end{align}
$$
