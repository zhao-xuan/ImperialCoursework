# Computational Techniques Coursework 5
### Solution 1
Using the $l_1$ norm, we can find the condition number using
$$
\text{cond}(A)=\lVert A^{-1}\rVert_1 \lVert A\rVert_1
$$
To find $A^{-1}$, we need to use the inverse matrix of a $2\times 2$ matrix
$$
\begin{align}
A^{-1}&=\frac{1}{\frac{1}{15} - \frac{1}{16}}\begin{bmatrix}
\frac{1}{5} & -\frac{1}{4}\\
-\frac{1}{4} & \frac{1}{3}
\end{bmatrix}\\
&=240\cdot \begin{bmatrix}
\frac{1}{5} & -\frac{1}{4}\\
-\frac{1}{4} & \frac{1}{3}
\end{bmatrix}\\
&=\begin{bmatrix}
48 & -60\\
-60 & 80
\end{bmatrix}
\end{align}
$$
Then we find $\lVert A^{-1}\rVert_1$ and $\lVert A\rVert_1$
$$
\begin{align}
\lVert A^{-1}\rVert&=140\\
\lVert A\rVert&=\frac{7}{12}
\end{align}
$$
Hence the condition number of $A$ using the $l_1$ norm is $\frac{245}{3}$

i) The condition of $A$ under $l_1$ norm is shown above. The condition number of $A$ is a relatively small figure($\frac{245}{3}\approx=81.67$), so this matrix is well-conditioned. The output size will change according to the input with a factor of $\frac{245}{3}$.

ii) The $l_{\infin}$ norm of $A$ is $\frac{7}{12}$ and the $l_2$ norm of $A$ is $\frac{\sqrt{497}}{30\sqrt{2}}$. The corresponding condition numbers of $A$ are as follows
$$
\text{cond$_{l_2}$($A$)}=\frac{\sqrt{497}}{30\sqrt{2}}\cdot \sqrt{15904}=\frac{1988}{30}=\frac{994}{15}
$$

$$
\text{cond$_{l_\infin}(A)$}=\frac{7}{12}\cdot 140=\frac{245}{3}
$$

### Solution 2

Using $l_\infin$ norm of $A$, we can find the condition number of $A$ as follows
$$
\text{cond(A)}=\lVert A\rVert_\infin\lVert A^{-1}\rVert_\infin=4\cdot 3=12
$$

### Solution 3

Using the $l_1$ norm of $A$, we can find its condition number as follows
$$
\begin{align}
A^{-1}&=-\frac{1}{13}\begin{bmatrix}
6 & 1 & 6\\
1 & -2 & 1\\
6 & 1 & 19
\end{bmatrix}
\end{align}
$$

$$
\text{cond(A)}=\lVert A\rVert_1\lVert A^{-1}\rVert_1=5\cdot0=0
$$

### Solution 4

To show that $x_n$ converges to $1$, we need to prove that $\forall \epsilon>0\exists N\in \R\ s.t. \forall n>N,|x_n-1|<\epsilon$.

We know that
$$
\begin{align}
|1+\frac{1}{n}-1|<\epsilon\\
\frac{1}{n}<\epsilon\\
\frac{1}{\epsilon}<n
\end{align}
$$
Let $N=\lceil\frac{1}{\epsilon}\rceil$, then this value of $N$ can always satisfy the statement above.

Hence, the sequence $x_n$ converges to $1$

### Solution 5

Using the Cauchy-test, we need to show that $\forall \epsilon>0\exists N\in R$ such that $\forall n>m>N, |a_n-a_m|<\epsilon$
$$
\begin{align}
|a_n-a_m|<\epsilon\\
|\sum_{i=1}^{n}\frac{1}{i}-\sum_{i=1}^{m}\frac{1}{i}|<\epsilon\\
\sum_{i=m+1}^{n}\frac{1}{i}<\epsilon\\
\end{align}
$$
No matter how big $N$ is, we can always know that
$$
\sum_{i=m+1}^{n}\frac{1}{i}>\sum_{i=m+1}^{n}\frac{1}{n}
$$
Hence we can always find a smaller value $\epsilon$ than $|a_n-a_m|$, which proves that there is no $N$ satisfying the given condition and the series diverges.

Without using the Cauchy-test, we can say that
$$
\begin{align}
\frac{1}{1}+\frac{1}{2}+\frac{1}{3}+\frac{1}{4}+...&=1+(\frac{1}{2})+(\frac{1}{3}+\frac{1}{4})+(\frac{1}{5}+\frac{1}{6}+\frac{1}{7}+\frac{1}{8})+...\\
&>1+(\frac{1}{2})+(\frac{1}{4}+\frac{1}{4})+(\frac{1}{8}+\frac{1}{8}+\frac{1}{8}+\frac{1}{8})+...\\
&=1+\frac{1}{2}+\frac{1}{2}+...=\infin
\end{align}
$$

### Solution 6

i) The matrix $M$ and vector $\vec{c}$ are as follows
$$
\begin{align}
\vec{v}_{n+1}&=\textbf{M}\vec{v}_n+\vec{c}\\
\begin{bmatrix}
a_{n+1}\\
b_{n+1}
\end{bmatrix}&=\textbf{M}\begin{bmatrix}
a_n\\
b_n
\end{bmatrix}+\vec{c}\\
\begin{bmatrix}
a_{n+1}\\
b_{n+1}
\end{bmatrix}&=\begin{bmatrix}
\alpha & 0\\
0 & \beta
\end{bmatrix}\begin{bmatrix}
a_n\\b_n
\end{bmatrix}+\begin{bmatrix}
1\\2
\end{bmatrix}
\end{align}
$$
​	Therefore
$$
M=\begin{bmatrix}
\alpha & 0\\
0 & \beta
\end{bmatrix}, \vec{c}=\begin{bmatrix}
1\\2
\end{bmatrix}
$$
ii) We can prove that $\vec{v}_n$ will converge as $n\rightarrow \infin$ by showing that $f(\vec{v})=\textbf{M}\vec{v}+\vec{c}$ is a contraction.
$$
\begin{align}
\lVert f(\vec{v}_1)-f(\vec{v}_2)\rVert&=\lVert \textbf{M}\vec{v}_1+\vec{c}-\textbf{M}\vec{v}_2-\vec{c}\rVert\\
&=\lVert\textbf{M}(\vec{v}_1-\vec{v}_2)\rVert\\
&\le \lVert \textbf{M}\rVert\lVert\vec{v}_1-\vec{v}_2\rVert
\end{align}
$$
​	Since $\alpha, \beta<1$, we have $\lVert M\rVert_1<1$ and $\lVert M\rVert_\infin<1$. Using either of the two (consistent) norm we can confirm that $d(f(\vec{v}_1), f(\vec{v}_2))\le \sigma(\vec{v}_1, \vec{v}_2)$, where $\sigma<1$. This proves that $f(\vec{v})$ is a contraction. By the Fixed Point Theorem, there exists a $\vec{v}_n$ such that $\vec{v}_n=\textbf{M}\vec{v}_n+\vec{c}$.
$$
\begin{align}
\begin{bmatrix}
a_n\\b_m
\end{bmatrix}&=\begin{bmatrix}
\alpha & 0\\
0 & \beta
\end{bmatrix}\begin{bmatrix}
a_n\\b_n
\end{bmatrix}+\begin{bmatrix}
1\\2
\end{bmatrix}\\
\begin{bmatrix}
(1-\alpha)a_n\\
(1-\beta)b_n
\end{bmatrix}&=\begin{bmatrix}
1\\2
\end{bmatrix}\\
\begin{bmatrix}
a_n\\b_n
\end{bmatrix}&=\begin{bmatrix}
\frac{1}{1-\alpha}\\
\frac{2}{1-\beta}
\end{bmatrix}
\end{align}
$$
​	Hence $\vec{v}_n$ converges to $\begin{bmatrix}\frac{1}{1-\alpha}\\\frac{2}{1-\beta}\end{bmatrix}$ when $n\rightarrow\infin$.

​	The reason that $a_n$ and $b_n$ converge is as follows
$$
\begin{align}
a_n=\alpha a_{n-1}+1&=\alpha(\alpha a_{n-2}+1)+1\\
&=\alpha^2a_{n-2}+\alpha+1\\
&=\alpha^3a_{n-3}+\alpha^2+\alpha+1\\
&=\alpha^{n-1}a_1+\alpha^{n-2}+\alpha^{n-3}+...+1
\end{align}
$$
​	When $n\rightarrow\infin$, $\alpha^{n-1}\rightarrow 0$ and $\alpha^{n-2}+\alpha^{n-3}+...+1=\frac{1}{1-\alpha}$. Hence $a_n=\frac{1}{1-\alpha}$ when $n\rightarrow \infin$. Same reasoning for the convergence of $b_n$.

iii) From the information given in the question, we have
$$
\begin{align}
a_{n+1}&=\alpha a_n+1\\
b_{n+1}&=\beta b_n+2\\
c_{n+1}&=a_{n+1}+b_{n+1}=\alpha a_n+\beta b_n+3=(\alpha-\beta)a_n+\beta(a_n+b_n)+3=(\alpha-\beta)a_n+\beta c_n+3
\end{align}
$$
​	Hence we can construct the linear system
$$
\begin{align}
\begin{bmatrix}
a_{n+1}\\
b_{n+1}\\
c_{n+1}
\end{bmatrix}&=\begin{bmatrix}
\alpha a_n & 0 & 0\\
0 & \beta b_n & 0\\
(\alpha - \beta) a_n & 0 & \beta c_n
\end{bmatrix}+\begin{bmatrix}
1\\2\\3
\end{bmatrix}\\
&=\begin{bmatrix}
\alpha & 0 & 0\\
0 & \beta & 0\\
\alpha - \beta & 0 & \beta
\end{bmatrix}\begin{bmatrix}
a_n\\b_n\\c_n
\end{bmatrix}+\begin{bmatrix}
1\\2\\3
\end{bmatrix}
\end{align}
$$
​	which proves the statement.

​	We can show that $c_n$ converges by showing that $\vec{w}_n$ converges

​	Again, we will show that $f(\vec{w}_n)=\textbf{M}'\vec{w}_n+\vec{c}'$ is a contraction
$$
\begin{align}
\lVert f(\vec{w}_{1}) - f(\vec{w}_2)\rVert&=\lVert\textbf{M}'\vec{w}_1+\vec{c}'-\textbf{M}'\vec{w}_2-\vec{c}'\rVert\\
&=\lVert \textbf{M}'(\vec{w}_1-\vec{w}_2)\rVert\\
&\le\lVert\textbf{M}'\rVert\lVert\vec{w}_1-\vec{w}_2\rVert 
\end{align}
$$
 

​	By choose a consistent norm such as $l_\infin$ norm, we can show that $\lVert M'\rVert<1$.
$$
l_\infin=\max_{i}\sum_{j}w_{ij}=\alpha<1
$$
​	which means tht $f(\vec{w})$ is a contraction and that there exists a $\vec{w}_n$ such that $\vec{w}_n=\textbf{M}'\vec{w}_n+\vec{c}'$
$$
\begin{align}
(\textbf{I}_3-\textbf{M}')\vec{w}_n&=\vec{c}'\\
\begin{bmatrix}
1-\alpha & 0 & 0\\
0 & 1-\beta & 0\\
\beta-\alpha & 0 & 1-\beta
\end{bmatrix}\begin{bmatrix}
a_n\\b_n\\c_n
\end{bmatrix}&=\begin{bmatrix}
1\\2\\3
\end{bmatrix}\\
\begin{bmatrix}
(1-\alpha)a_n\\
(1-\beta)b_n\\
(\beta-\alpha)a_n+(1-\beta)c_n
\end{bmatrix}&=\begin{bmatrix}
1\\2\\3
\end{bmatrix}\\
\begin{bmatrix}
a_n\\b_n\\c_n
\end{bmatrix}&=\begin{bmatrix}
\frac{1}{1-\alpha}\\
\frac{2}{1-\beta}\\
\frac{3-\frac{\beta-\alpha}{1-\alpha}}{1-\beta}
\end{bmatrix}=\begin{bmatrix}
\frac{1}{1-\alpha}\\
\frac{2}{1-\beta}\\
\frac{3-2\alpha-\beta}{(1-\alpha)(1-\beta)}
\end{bmatrix}
\end{align}
$$
​	Hence $c_n$ will converges to $\frac{3-2\alpha-\beta}{(1-\alpha)(1-\beta)}$ when $n\rightarrow \infin$

### Solution 7

Metric space is a non-empty set $S$ of points together with a mapping $d:S\times S\rightarrow \R$ satisfying the following properties
$$
\begin{align}
d(x,x)&=0\\
d(x,y)&>0\text{ if }x\ne y\\
d(x,y)&=d(y,x)\\
d(x,y)&\le d(x,z)+d(z,y)\\
\end{align}
$$
The norm of the difference between two vectors satisfies those properties. Let $A$, $B$ and $C$ be three different matrices, then
$$
\begin{align}
\lVert A-A\rVert&=\lVert \textbf{0}\rVert=0\\
\lVert A-B\rVert&>0 & (\text{by the definition of norm e.g.$\sum_{ij}(x_{ij}^{p})^{\frac{1}{p}}$})\\
\lVert A-B\rVert&=\lVert B-A\rVert & (\text{since the norms are taken with absolute values})\\
\lVert A-C\rVert&\le\lVert A-B\rVert+\lVert B-C\rVert & (\text{by triangular inequality})
\end{align}
$$
We now prove that $(\textbf{I}-\textbf{M})\textbf{G}_n=\textbf{I}-\textbf{M}^{n+1}$
$$
\begin{align}
(\textbf{I}-\textbf{M})\textbf{G}_n&=\textbf{G}_n-\textbf{MG}_n\\
&=\textbf{I}+\textbf{M}+\textbf{M}^2+\textbf{M}^3+...+\textbf{M}^n-(\textbf{M}+\textbf{M}^2+\textbf{M}^3+...+\textbf{M}^{n+1})\\
&=\textbf{I}+(\textbf{M}-\textbf{M})+(\textbf{M}^2-\textbf{M}^2)+...+(\textbf{M}^n-\textbf{M}^n)-\textbf{M}^{n+1}\\
&=\textbf{I}-\textbf{M}^{n+1}
\end{align}
$$
For any submultiplicative matrix norm, we have
$$
\lVert Ax\rVert\le \lVert A\rVert\lVert x\rVert
$$
Hence for $\textbf{M}^n$ we have
$$
\lVert \textbf{M}^n\rVert\le \lVert \textbf{M}^{n-1}\rVert\lVert \textbf{M}\rVert\le \lVert \textbf{M}^{n-2}\rVert\lVert \textbf{M}\rVert\lVert \textbf{M}\rVert\le ...\le \lVert \textbf{M}\rVert^n
$$
Since $\lVert \textbf{M}\rVert<1$, when $n\rightarrow \infin$, $\lVert \textbf{M}\rVert^n\rightarrow 0$ and hence $\lVert \textbf{M}^n\rVert\rightarrow 0$, which means that $\textbf{M}^n$ is the zero matrix.

From the previous equation of $(\textbf{I}-\textbf{M})\textbf{G}_n=\textbf{I}-\textbf{M}^{n+1}$, when $n\rightarrow\infin$, it becomes
$$
\begin{align}
(\textbf{I}-\textbf{M})\textbf{G}_\infin&=\textbf{I}-\textbf{0}\\
\textbf{G}_\infin&=(\textbf{I}-\textbf{M})^{-1}
\end{align}
$$

### Solution 8

In order to use the matrix $\textbf{M}^2$, we need to construct $\vec{v}_{n+1}=\textbf{M}^2\vec{v}_{n-1}$.

To prove the convergence of $\vec{v}_n$, we need to show that $f(\vec{v})=\textbf{M}^2\vec{v}$ is a contraction
$$
\begin{align}
\lVert f(\vec{v}_1)-f(\vec{v}_2)\rVert&=\lVert\textbf{M}^2\vec{v}_1-\textbf{M}^2\vec{v}_2\rVert\\
&=\lVert\textbf{M}^2(\vec{v}_1-\vec{v}_2)\rVert\\
&\le \lVert \textbf{M}^2\rVert\lVert \vec{v}_1-\vec{v}_2\rVert
\end{align}
$$
We now show that $\lVert \textbf{M}^2\rVert<1$ by choosing a suitable norm
$$
\textbf{M}^2=\begin{bmatrix}
0.75 & 0.2\\
1 & 0
\end{bmatrix}\begin{bmatrix}
0.75 & 0.2\\
1 & 0
\end{bmatrix}=\frac{1}{80}\begin{bmatrix}
61 & 12\\
60 & 16
\end{bmatrix}
$$
We then choose the consistent $l_\infin$ norm of the matrix and hence $\lVert\textbf{M}^2\rVert_\infin=\frac{76}{80}<1$

This proves that $f(\vec{v}_n)$ is a contraction and by the Fixed Point Theorem, ther exists a $\vec{v}_n$ such that $\vec{v}_n=\textbf{M}^2\vec{v}_n$
$$
\begin{align}
\begin{bmatrix}
x_{n+1}\\
x_n
\end{bmatrix}&=\frac{1}{80}\begin{bmatrix}
61 & 12\\
60 & 16
\end{bmatrix}\begin{bmatrix}
x_{n+1}\\x_n
\end{bmatrix}\\
80\begin{bmatrix}
x_{n+1}\\
x_n
\end{bmatrix}&=\begin{bmatrix}
61 & 12\\
60 & 16
\end{bmatrix}\begin{bmatrix}
x_{n+1}\\x_n
\end{bmatrix}\\

&\Rightarrow \left\{ \begin{matrix}
80x_{n+1}=61x_{n+1}+12x_n\\
80x_n=60x_{n+1}+16x_n
\end{matrix}
\right.\\
&\Rightarrow \left\{ \begin{matrix}
x_{n+1}=\frac{76}{79}x_n\\
x_n=0
\end{matrix}
\right.\\
&\Rightarrow x_{n+1}=x_n=0
\end{align}
$$
Hence $\vec{v}_\infin=\vec{0}$ and $x_\infin=0$