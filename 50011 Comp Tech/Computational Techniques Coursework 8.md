# Computational Techniques Coursework 8

### Solution 1

i) To compute the local extreme point, we will make the second term in Taylor's series equal to 0
$$
\begin{align}
\frac{\part}{\part x}f(x,y)=-y=0\Rightarrow y=0\\\frac{\part}{\part y}f(x,y)=-x=0\Rightarrow x=0
\end{align}
$$
​	The Hessian matrix of $f(x,y)$ is
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
0 & -1\\
-1 & 0
\end{bmatrix}
$$
​	Since the eigenvalue of $H$ is $\pm 1$, we know that $H$ is indefinite, and hence $f(x,y)$ has no extreme point(max or min) exists at point $(0,0)$.

ii) Similarly as computed in i):
$$
\begin{align}
\frac{\part}{\part x}f(x,y)=2x=0\Rightarrow x=0\\
\frac{\part}{\part y}f(x,y)=-3y^2=0\Rightarrow y=0
\end{align}
$$
​	the Hessian matrix of $f(x,y)$ is 
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
2 & 0\\
0 & -6y
\end{bmatrix}
$$
​	When $y=0$, the determinant of $H$ is 0 and hence $H$ is indefinite and hence there is no extreme point exists at point $(0,0)$.

iii) Similarly as computed above
$$
\begin{align}
\frac{\part}{\part x}f(x,y)=2x=0\Rightarrow x=0\\
\frac{\part}{\part y}f(x,y)=2y=0\Rightarrow y=0
\end{align}
$$
​	the Hessian matrix of $f(x,y)$ is 
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
2 & 0\\
0 & 2
\end{bmatrix}
$$
​	Since the only eigenvalues of $H$ is $2$ and its determinant is positive, we know that $H$ is positive definite and has a local minimum at $(0,0)$ with value $f(0,0)=0$.

### Solution 2

a) We first compute the Hessian matrix of $f_1(x,y)$
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
2 & 0\\
0 & 2
\end{bmatrix}
$$
​	Since the only eigenvalues of $H$ is $2$ and its determinant is positive, we know that $H$ is positive definite and has a local minimum.

​	We then set $\frac{\part}{\part x}f_1(x,y)=0$ and $\frac{\part}{\part y}f_1(x,y)=0$
$$
\frac{\part}{\part x}f_1(x,y)=2x=0\Rightarrow x=0\\
\frac{\part}{\part y}f_1(x,y)=2y=0\Rightarrow y=0
$$
​	which indicates that $f_1(x,y)$ has a minimum at point $(0,0)$.

b) We first set $\frac{\part}{\part x}f_2(x,y)=0$ and $\frac{\part}{\part y}f_2(x,y)=0$
$$
\frac{\part}{\part x}f_2(x,y)=-2x=0\Rightarrow x=0\\
\frac{\part}{\part y}f_2(x,y)=2y=0\Rightarrow y=0
$$
​	then we compute the Hessian matrix of $f_2$
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
-2 & 0\\
0 & 2
\end{bmatrix}
$$
​	Since the eigenvalue of $H$ is $\pm 2$, we know that $f_2$ does not have maximum or minimum at $(0,0)$. Since the determinant is $-4<0$, we know that $f_2$ has a saddle point at $(0,0)$.

c) We first set $\frac{\part}{\part x}f_3(x,y)=0$ and $\frac{\part}{\part y}f_3(x,y)=0$
$$
\frac{\part}{\part x}f_3(x,y)=3x^2+6y=0\\
\frac{\part}{\part y}f_3(x,y)=-3y^2+6x=0
$$
​	which leads to the solution
$$
x_1=0, y_1=0\\
x_2=2, y_2=-2
$$
​	We now check the nature of those two critical points.

​	We then compute the Hessian matrix of $f_3$
$$
H=\begin{bmatrix}
f_{11} & f_{12}\\
f_{21} & f_{22}
\end{bmatrix}=\begin{bmatrix}
6x & 6\\
6 & -6y^2
\end{bmatrix}
$$
​	when $x=0, y=0$, the eigenvalues of $H$ are $\pm 6$ and the determinant of $H$ is $-36<0$. Hence the point $(0,0)$ is a saddle point.

​	when $x=2,y=-2$, the determinant of $H$ is $-324<0$ and its eigenvalue is around $12.97$. Hence $H$ is indefinite and $(2,-2)$ forms a saddle point.