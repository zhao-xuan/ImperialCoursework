# 2020 Computational Technique Examination Solution

1. a. i) To find the singular value decomposition of $A$, we need to first find $A^TA$. Notice that in this case we can also choose $AA^T$ since they have the same dimension.
   $$
   A^TA=\begin{bmatrix}
   8 & 2 & 0\\
   2 & 5 & 0\\
   0 & 0 & 0
   \end{bmatrix}
   $$
   Then we find the spectral decomposition of $A^TA$. First we need to compute the eigenvalues and eigenvectors of $A^TA$ in order to find its spectral decomposition.

   The characteristic polynomial is
   $$
   \begin{align}
   -\lambda(8-\lambda)(5-\lambda)+4\lambda=0\\
   \lambda(4-40+13\lambda-\lambda^2)=0\\
   -\lambda(\lambda-4)(\lambda-9)=0
   \end{align}
   $$
   Hence the eigenvalues aree $\lambda_1=0,\lambda_2=4,\lambda_3=9$

   The corresponding normalized eigenvectors are
   $$
   e_1=\begin{bmatrix}
   0\\0\\1
   \end{bmatrix},
   e_2=\frac{1}{\sqrt{5}}\begin{bmatrix}
   1\\-2\\0
   \end{bmatrix},
   e_3=\frac{1}{\sqrt{5}}\begin{bmatrix}
   2\\1\\0
   \end{bmatrix}
   $$
   We then put them together by the order of eigenvalue from highest to lowest to form $V$.
   $$
   V=\frac{1}{\sqrt{5}}\begin{bmatrix}
   2 & 1 & 0\\
   1 & -2 & 0\\
   0 & 0 & \sqrt{5}
   \end{bmatrix}
   $$
   Then we use the fact that $US=AV$ to calculate $U$
   $$
   u_1=\frac{1}{\sigma_1}Av_1=\frac{1}{\sqrt{9}}\cdot \frac{1}{\sqrt{5}}\begin{bmatrix}
   4\\5\\-2
   \end{bmatrix}=\frac{1}{\sqrt{5}}\begin{bmatrix}
   \frac{4}{3}\\\frac{5}{3}\\-\frac{2}{3}
   \end{bmatrix}\\
   u_2=\frac{1}{\sigma_2}Av_2=\frac{1}{\sqrt{4}}\cdot\frac{1}{\sqrt{5}}\begin{bmatrix}
   2\\0\\4
   \end{bmatrix}=\frac{1}{\sqrt{5}}\begin{bmatrix}
   1\\0\\2
   \end{bmatrix}
   $$
   We can calculate $u_3$ by using the cross product which will reesult in a vector perpendicular to $u_1$ and $u_2$
   $$
   u_3=u_1\times u_2=\begin{vmatrix}
   i & j & k\\
   \frac{4}{3\sqrt{5}} & \frac{5}{3\sqrt{5}} & -\frac{2}{3\sqrt{5}}\\
   \frac{1}{\sqrt{5}} & 0 & \frac{2}{\sqrt{5}}
   \end{vmatrix}=\begin{bmatrix}
   \frac{2}{3}\\-\frac{2}{3}\\-\frac{1}{3}
   \end{bmatrix}
   $$
   Thus we have found the singular value decomposition of A
   $$
   \begin{align}
   A=USV^T&=\begin{bmatrix}
   \frac{4}{3\sqrt{5}} & \frac{1}{\sqrt{5}} & \frac{2}{3}\\
   \frac{5}{3\sqrt{5}} & 0 & -\frac{2}{3}\\
   -\frac{2}{3\sqrt{5}} & \frac{2}{\sqrt{5}} & -\frac{1}{3}
   \end{bmatrix}\begin{bmatrix}
   3 & 0 & 0\\
   0 & 2 & 0\\
   0 & 0 & 0
   \end{bmatrix}\frac{1}{\sqrt{5}}\begin{bmatrix}
   2 & 1 & 0\\
   1 & -2 & 0\\
   0 & 0 & \sqrt{5}
   \end{bmatrix}\\
   &=\frac{1}{\sqrt{5}}\begin{bmatrix}
   \frac{4}{\sqrt{5}} & \frac{2}{\sqrt{5}} & 0\\
   \sqrt{5} & 0 & 0\\
   -\frac{2}{\sqrt{5}} & \frac{4}{\sqrt{5}} & 0
   \end{bmatrix}\begin{bmatrix}
   2 & 1 & 0\\
   1 & -2 & 0\\
   0 & 0 & \sqrt{5}
   \end{bmatrix}\\
   &=\begin{bmatrix}
   2 & 0 & 0\\
   2 & 1 & 0\\
   0 & -2 & 0
   \end{bmatrix}
   \end{align}
   $$
   ​	ii) $\lVert A\rVert_2=3$, which is the largest singular value of $A$

   b. i) Notice that $A$ is a symmetric matrix. We will find the Cholesky factorisation as follows
   $$
   A=\begin{bmatrix}
   l_{11} & 0 & 0\\
   l_{21} & l_{22} & 0\\
   l_{31} & l_{32} & l_{33}
   \end{bmatrix}
   \begin{bmatrix}
   l_{11} & l_{21} & l_{31}\\
   0 & l_{22} & l_{32}\\
   0 & 0 & l_{33}
   \end{bmatrix}
   $$
   ​		Hence we know that $l_{11}^2=4\Rightarrow l_{11}=2$, $l_{11}l_{21}=12\Rightarrow l_{21}=6$, $l_{11}l_{31}=-16\Rightarrow l_{31}=-8$, $l_{21}^2+l_{22}^2=37\Rightarrow l_{22}=1$, $l_{21}l_{31}+l_{22}l_{32}=-43\Rightarrow l_{32}=5$, $l_{31}^2+l_{32}^2+l_{33}^2=98\Rightarrow 3$

   ​		which is shown as below
   $$
   L=\begin{bmatrix}
   2 & 0 & 0\\
   6 & 1 & 0\\
   -8 & 5 & 3
   \end{bmatrix}
   $$
   

   ​	ii) Since all elements on the diagnal of $L$ are all positive, $A$ is positive definite.

   c. We perform a QR decomposition as follows
   $$
   u_1=a_1=\begin{bmatrix}
   -1\\1\\-1\\1
   \end{bmatrix},e_1=\frac{u_1}{\lVert u_1\rVert}=\frac{1}{2}\begin{bmatrix}
   -1\\1\\-1\\1
   \end{bmatrix}
   $$

   $$
   e_1\cdot a_1=2, e_1\cdot a_2=4
   $$

   $$
   u_2=a_2-(e_1\cdot a_2)e_1=\begin{bmatrix}
   1\\1\\1\\1
   \end{bmatrix},e_2=\frac{1}{2}\begin{bmatrix}
   1\\1\\1\\1
   \end{bmatrix},e_2\cdot a_2=2
   $$

   ​	Hence we have
   $$
   Q=[e_1,e_2]=\frac{1}{2}\begin{bmatrix}
   -1 & 1\\
   1 & 1\\
   -1 & 1\\
   1 & 1
   \end{bmatrix},R=\begin{bmatrix}
   e_1\cdot a_1 & e_1\cdot a_2\\
   0 & e_2\cdot a_2
   \end{bmatrix}=\begin{bmatrix}
   2 & 4\\
   0 & 2
   \end{bmatrix}
   $$
   ​	where
   $$
   QR=
   \frac{1}{2}\begin{bmatrix}
   -1 & 1\\
   1 & 1\\
   -1 & 1\\
   1 & 1
   \end{bmatrix}\begin{bmatrix}
   2 & 4\\
   0 & 2
   \end{bmatrix}=\begin{bmatrix}
   -1 & -1\\
   1 & 3\\
   -1 & -1\\
   1 & 3
   \end{bmatrix}=A
   $$
   

   d. We show this property as follows. $w_{max}$ is the biggest element of $w$
   $$
   \begin{align}
   \lvert v\cdot w\rvert&=\lvert v_1w_1+v_2w_2+...+v_mw_m \rvert\\
   &\le \lvert v_1w_{max}+v_2w_{max}+...+v_mw_{max}\rvert\\
   &=\lvert w_{max}\rvert\lvert v_1+v_2+...+v_m \rvert\\
   &=\lVert w\rVert_{\infin}\lVert v\rVert_1
   \end{align}
   $$
   e. The columns of $A$ must be perpendicular to each other and are unit vectors. If the columns of $A$ satisfy these two conditions, then we have
   $$
   \begin{align}
   A^TA&=\begin{bmatrix}
   \textbf{a}_1\cdot \textbf{a}_1 & \textbf{a}_1\cdot \textbf{a}_2 & ...\\
   \textbf{a}_2\cdot \textbf{a}_1 & \textbf{a}_2\cdot \textbf{a}_2 & ...\\
   ... & ...& ...
   \end{bmatrix}\\
   &=\begin{bmatrix}
   1 & 0 & 0 & ...\\
   0 & 1 & 0 & ...\\
   0 & 0 & 1 & ...\\
   ... & ... & ... & ...
   \end{bmatrix}\\
   &=I
   \end{align}
   $$
   ​	where $\textbf{a}_j$ denotes the $j$th column of $A$. Since columns of $A$ are perpendicular to each other, we have
   $$
   \textbf{a}_i\cdot \textbf{a}_j=0, i\ne j
   $$
   ​	Since the columns of $A$ are all unit vectors, we have
   $$
   \textbf{a}_j\cdot \textbf{a}_j=1
   $$
   ​	Therefore we know that $A^T=A^{-1}$ and $A^TA=AA^T=I$.

   ​	Since $AA^T=\begin{bmatrix}\textbf{a}^1\cdot\textbf{a}^1 & \textbf{a}^1\cdot \textbf{a}^2 & ...\\\textbf{a}^2\cdot\textbf{a}^1 & \textbf{a}^2\cdot \textbf{a}^2 & ...\\...&...&...\end{bmatrix}=I$ wheree $\textbf{a}^i$ denotes the $i$th row of $A$, we know that $\textbf{a}^i\cdot \textbf{a}^i=1$ and $\textbf{a}^i\cdot \textbf{a}^j=0$ for $i\ne j$. Hence the row of $A$ (which is also the columns of $A^T$) are perpedicular to ecah other and they are all unit vectors.

2. a. i) The condition number of matrix $A$ is
$$
   \text{cond}(A)=\lVert A\rVert_\infin\lVert A^{-1}\rVert_\infin=30\cdot \frac{913}{268}=102.201
$$
   ​	ii) From the definition of vector norms and vector operations, we have
$$
   \begin{align}
   \lVert x-y\rVert&>0, x\ne y\\
   \lVert x-x\rVert&=0\\
   \lVert y-x\rVert&=\lVert-(x-y)\rVert=\lvert-1\rvert\lVert x-y\rVert=\lVert x-y\rVert\\
   \lVert x-y\rVert&=\lVert (x-z)+(z-y)\rVert\le \lVert x-z\rVert+\lVert z-y\rVert
   \end{align}
$$
   ​		which fits properly the definition of metric space:
$$
   \begin{align}
   d(x,x)&=0\\
   d(x,y)&>0, x\ne y\\
   d(x,y)&=d(y,x)\\
   d(x,y)&\le d(x,z)+d(z,y)
   \end{align}
$$
   ​		The matrix norm definition is contructed in similar way so that the proof of it defining a metric is also similar.

   ​	iii) Define the function $f$ as $f(\vec{v})=M\vec{v}$ and we will prove that $f$ is a contraction. Since the given norm is subordinate, we know that $\lVert M\vec{v}\rVert\le \lVert M\rVert\lVert\vec{v}\rVert$ for any vector $\vec{v}\in \R^n$.
$$
   \begin{align}
   \lVert M\vec{v_1}-M\vec{v_2}\rVert&=\lVert M(\vec{v_1}-\vec{v_2})\rVert\\
   &\le\lVert M \rVert\lVert\vec{v_1}-\vec{v_2}\rVert
   \end{align}
$$
   ​		Since $\lVert M \rVert=1$, by definition $f$ is a contraction. We construct a sequence $p_n=M^n\vec{v}$. By fixed point theorem, we know that as $n\rightarrow \infin$ there is an $n$ such that $f(p_n)=p_n$. Then we have:
$$
   \begin{align}
   Mp_n&=p_n\\
   (M-I)p_n&=0\\
   \end{align}
$$
   which indicates that either $M-I=0$ or $p_n=0$. $M$ might not possible be $I$ since under some subordinate norm $\lVert I\rVert=1$ (e.g. $l_1$ norm of matrix). Then we have $p_n=0$ as $n\rightarrow \infin$.

   b. i) By the definition of Laplace transformation, we have
$$
   \begin{align}
   (\mathcal{L}f_1)(s)&=\int_{0}^{\infin}e^{-st}f(t)dt\\
   &=\int_{0}^{\infin}e^{-st}dt\\
   &=(-\frac{e^{-st}}{s})\lvert_{0}^{\infin}\\
   &=0-(-\frac{1}{s})=\frac{1}{s}\\
   \end{align}
$$
   ​		By the fact that if $f(t)$ has LT $F(s)$ then $tf(t)$ has LT $-\frac{dF}{ds}$, we can easily obtain $(\mathcal{L}f_2)(s)=-\frac{d}{ds}(\mathcal{L}f_1)(s)=\frac{1}{s^2}$

   ​	ii) By taking Laplace transformation on both sides, we obtain
$$
   \begin{align}
   \begin{array}{}
   sF_1(s)-y_1(0)=25F_2(s)+\frac{1}{s^2}\\
   sF_2(s)-y_2(0)=F_1(s)
   \end{array}
   \Rightarrow
   \begin{array}{}
   sF_1(s)=25F_2(s)+\frac{1}{s^2}\\
   sF_2(s)=F_1(s)
   \end{array}
   \end{align}
$$
   ​		Using substitution we can obtain
$$
   \begin{align}
   s^2F_2(s)&=25F_2(s)+\frac{1}{s^2}\\
   (s^2-25)F_2(s)&=\frac{1}{s^2}\\
   F_2(s)&=\frac{1}{s^2(s+5)(s-5)}=-\frac{1}{25s^2}-\frac{1}{250(s+5)}+\frac{1}{250(s-5)}
   \end{align}
$$
   ​		and hence
$$
   y_2(t)=-\frac{t}{25}-\frac{e^{-5t}}{250}+\frac{e^{5t}}{250}
$$
   c. i) The proof is as follows
$$
\begin{align}
\frac{\part f(\vec{x})}{\part\vec{x}}&=\frac{1}{2}(A\vec{x}+\vec{x}^TA)-\vec{b}+0\\
&=\frac{1}{2}(A\vec{x}+A\vec{x})-\vec{b}\\
&=A\vec{x}-\vec{b}
\end{align}
$$
​		ii) The steepest descent vector is
$$
-\nabla f(x_0,y_0)=-(2x_0+2\gamma y_0)=-2(x_0+\gamma y_0)\Rightarrow -2(x_0,\gamma y_0)
$$
​		iii) We need to minimize the following equation
$$
\begin{align}
f(x_1,x_0)&=(1-c)^2x_0^2+\gamma(1-c\gamma)^2y_0^2\\
\frac{df}{dc}&=-2(1-c)x_0^2-2\gamma^2(1-c\gamma)y_0^2\\
&=-2(x_0^2-cx_0^2+\gamma^2y_0^2-c\gamma^3y_0^2)=0\\
\Rightarrow x_0^2+\gamma^2y_0^2&=c(x_0^2+\gamma^3 y_0^2)\\
c&=\frac{x_0^2+\gamma^2y_0^2}{x_0^2+\gamma^3 y_0^2}
\end{align}
$$
​		iv) When $\gamma=1$, the deepest descent is $\begin{bmatrix}-2x_0\\-2y_0\end{bmatrix}$. From the definition of $f(x,y)$ we know that $A=\begin{bmatrix}2&0\\0&2\end{bmatrix}$.

​			Thereby, the next iteration will produce
$$
x_1=x_0+\frac{4x_0^2+4y_0^2}{8x_0^2+8y_0^2}\begin{bmatrix}
-2x_0\\-2y_0
\end{bmatrix}=0,y_1=0
$$
​			From iii) we know that when $c=\frac{x_0^2+\gamma^2y_0^2}{x_0^2+\gamma^3y_0^2}$ the stationary point will occur. When $\gamma=1$, $c=1$ and thus $x_1=(1-1)x_0=0$ and $y_0=(1-1)y_0=0$.

​			Hence it will only take one iteration.