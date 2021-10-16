# 2019 Computational Technique Examination Solution

1. a. i) To find the singular value decomposition of $A=USV^T$, we need to find the spectral decomposition of $A^TA$ whose dimension is smaller than $AA^T$.

   ​		We first calculate $A^TA$
   $$
   A^TA=\begin{bmatrix}
   1 & 1 & 1 & 1\\
   1 & -1 & 1 & -1\\
   -1 & 1 & -1 & 1
   \end{bmatrix}\begin{bmatrix}
   1 & 1 & -1\\
   1 & -1 & 1\\
   1 & 1 & -1\\
   1 & -1 & 1
   \end{bmatrix}=\begin{bmatrix}
   4 & 0 & 0\\
   0 & 4 & -4\\
   0 & -4 & 4
   \end{bmatrix}
   $$
   ​		We then calculate the eigenvalues and eigenvectors of $A^TA$, with the characteristic polynomial being
   $$
   \begin{align}
   (4-\lambda)^3-16(4-\lambda)&=0\\
   (4-\lambda)((4-\lambda)^2-16)&=0\\
   (4-\lambda)(8-\lambda)\lambda&=0\\
   \lambda&=0,4,8
   \end{align}
   $$
   ​		The corresponding normalized eigenvector is
   $$
   \begin{align}
   E_0=\frac{1}{\sqrt{2}}\begin{bmatrix}
   0\\1\\1
   \end{bmatrix},
   E_4=\begin{bmatrix}
   1\\0\\0
   \end{bmatrix},
   E_8=\frac{1}{\sqrt{2}}\begin{bmatrix}
   0\\1\\-1
   \end{bmatrix}
   \end{align}
   $$
   ​		We have now obtained $V=[E_8,E_4,E_0]$

   ​		Then we use the fact that $US=AV$ to calculate the columns of $U$
   $$
   u_1=\frac{1}{\sigma_1}Av_1=\frac{1}{\sqrt{8}\cdot \sqrt{2}}\begin{bmatrix}2\\-2\\2\\-2\end{bmatrix}=\frac{1}{2}\begin{bmatrix}1\\-1\\1\\-1\end{bmatrix}\\
   u_2=\frac{1}{\sigma_2}Av_2=\frac{1}{\sqrt{4}}\begin{bmatrix}
   1\\1\\1\\1\end{bmatrix}=\frac{1}{2}\begin{bmatrix}
   1\\1\\1\\1\end{bmatrix}
   $$
   ​		We then calculate $u_3$ using the fact that $u_1\cdot u_3=0$ and $u_2\cdot u_3=0$.
   $$
   a-b+c-d=0\\
   a+b+c+d=0\\
   \Rightarrow a=-c, b=-d
   $$
   ​		where $a, b, c, d$ are the four elements in $u_3$. Hence $u_3=\begin{bmatrix}a & b & -a & -b\end{bmatrix}^T$We then use this to find $u_4$.
   $$
   i-j+k-l=0\\
   i+j+k+l=0\\
   \Rightarrow i=-k, j=-l\\
   ia+jb-ka-lb=0\Rightarrow (i-k)a+(j-l)b=0\Rightarrow 2ia+2jb=0
   $$
   ​		where $i, j, k, l$ are the four elements in $u_4$. Using this constraint, we can choose any unit vector $u_3$ and $u_4$ here. For instance, we can set $a=1, b=2$ and hence $c=-1, d=-2$ to get $u_3$. We can then set $i=1, j=-\frac{1}{2}$ and hence $k=-1, l=\frac{1}{2}$. Of course you can set them to any value as long as the constraints above is satisfied. In fact, you will see later in the calculation, $u_3$ and $u_4$ simply do not matter as they will be multiplied by $0$ in the matrix multiplcaition of $US$.

   ​		The normalized $u_3$ and $u_4$ are $u_3=\frac{1}{\sqrt{5}}\begin{bmatrix}1\\2\\-1\\-2\end{bmatrix}$ and $u_4=\frac{2}{\sqrt{10}}\begin{bmatrix}1\\-\frac{1}{2}\\-1\\\frac{1}{2}\end{bmatrix}$.

   ​		We have now obtained $U=[u_1,u_2,u_3,u_4]$

   ​		Hence the singular value decomposition of $A$ is
   $$
   \begin{align}
   A=USV^T&=\frac{1}{\sqrt{2}}\begin{bmatrix}
   \frac{1}{2} & \frac{1}{2} & 1\over\sqrt{5} & \frac{2}{\sqrt{10}}\\
   -\frac{1}{2} & \frac{1}{2} & 2\over\sqrt{5} & -\frac{1}{\sqrt{10}}\\
   \frac{1}{2} & \frac{1}{2} & -1\over\sqrt{5} & -\frac{2}{\sqrt{10}}\\
   -\frac{1}{2} & \frac{1}{2} & -2\over\sqrt{5} & \frac{1}{\sqrt{10}}
   \end{bmatrix}\begin{bmatrix}
   \sqrt{8} & 0 & 0\\
   0 & 2 & 0\\
   0 & 0 & 0\\
   0 & 0 & 0
   \end{bmatrix}
   \begin{bmatrix}
   0 & 1 & -1\\
   \sqrt{2} & 0 & 0\\
   0 & 1 & 1
   \end{bmatrix}\\
   
   &=\begin{bmatrix}
   \frac{1}{2} & \frac{1}{2} & 1\over\sqrt{5} & \frac{2}{\sqrt{10}}\\
   -\frac{1}{2} & \frac{1}{2} & 2\over\sqrt{5} & -\frac{1}{\sqrt{10}}\\
   \frac{1}{2} & \frac{1}{2} & -1\over\sqrt{5} & -\frac{2}{\sqrt{10}}\\
   -\frac{1}{2} & \frac{1}{2} & -2\over\sqrt{5} & \frac{1}{\sqrt{10}}
   \end{bmatrix}\begin{bmatrix}
   2 & 0 & 0\\
   0 & \sqrt{2} & 0\\
   0 & 0 & 0\\
   0 & 0 & 0
   \end{bmatrix}
   \begin{bmatrix}
   0 & 1 & -1\\
   \sqrt{2} & 0 & 0\\
   0 & 1 & 1
   \end{bmatrix}\\
   &=\begin{bmatrix}
   1 & \frac{\sqrt{2}}{2} & 0\\
   -1 & \frac{\sqrt{2}}{2} & 0\\
   1 & \frac{\sqrt{2}}{2} & 0\\
   -1 & \frac{\sqrt{2}}{2} & 0\\
   \end{bmatrix}\begin{bmatrix}
   0 & 1 & -1\\
   \sqrt{2} & 0 & 0\\
   0 & 1 & 1
   \end{bmatrix}\\
   &=\begin{bmatrix}
   1 & 1 & -1\\
   1 & -1 & 1\\
   1 & 1 & 1\\
   1 & -1 & 1
   \end{bmatrix}
   \end{align}
   $$
   ​	ii) $\lVert A\rVert_2=2\sqrt{2}$, which is the largest singular value of $A$

   b. We will use the normal equation to find the solution for this least square problem.
   $$
   A=\begin{bmatrix}
   1 & -1 & 1\\
   -1 & 1 & 1\\
   1 & 1 & 1\\
   -1 & -1 & 1
   \end{bmatrix}\\
   Ax=b\Rightarrow \begin{bmatrix}
   1 & -1 & 1\\
   -1 & 1 & 1\\
   1 & 1 & 1\\
   -1 & -1 & 1
   \end{bmatrix}\begin{bmatrix}
   a\\b\\h
   \end{bmatrix}=\begin{bmatrix}
   -1\\-1\\5\\1
   \end{bmatrix}
   $$
   ​	Then we use the normal equation
   $$
   \begin{align}
   A^TAx&=A^Tb\\
   \begin{bmatrix}
   4 & 0 & 0\\
   0 & 4 & 0\\
   0 & 0 & 4
   \end{bmatrix}\begin{bmatrix}
   a\\b\\h
   \end{bmatrix}&=\begin{bmatrix}
   4\\4\\4
   \end{bmatrix}
   \end{align}
   $$
   ​	which yields $a=b=h=1$

   c. 