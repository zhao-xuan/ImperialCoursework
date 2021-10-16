# Computational Techniques - Review of Linear Maps, vector, and Matrix Norms

### Solution 1

$$
(\mathbf{AB})^T=(\sum_{k=1}^{n}\textbf{A}_{ik}\textbf{B}_{kj})^T=\sum_{k=1}^{n}\textbf{A}^T_{ki}\textbf{B}^T_{jk}=\sum_{k=1}^{n}\textbf{B}^T_{jk}\textbf{A}^T_{ki}=\textbf{B}^T\textbf{A}^T
$$

### Solution 2

If two vectors are mutually orthogonal, they must satisfy that
$$
\textbf{a}\cdot \textbf{b}=0
$$
a) $[2,5,1]\cdot [-3,1,1]^T=-6+5+1=0$, hence they are mutually orthogonal.

b) $[3,5,3,-4]\cdot [4,-2,2,3]=12-10+6-12=-4$, hence they are NOT mutually orthogonal

We then use the first pair to construct an orthonormal set with $\textbf{v}_1$ and $\textbf{v}_2$ being the multiples of the given pair. To find $\textbf{v}_3$, we have to use the following properties:
$$
\textbf{v}_1\cdot \textbf{v}_3=0\\
\textbf{v}_2\cdot \textbf{v}_3=0
$$
We know that $\textbf{v}_1$ and $\textbf{v}_2$ are the multiples of the given pair, so they must have the same direction, hence we can use the given pair to find $\textbf{v}_3$. Let $\textbf{v}_3=[x_1,x_2,x_3]$
$$
\begin{align}
[2,5,1]\cdot \textbf{v}_3=0\\
[-3,1,1]\cdot \textbf{v}_3=0
\end{align}
\Rightarrow
\begin{matrix}
2x_1+5x_2+x_3=0\\
-3x_1+x_2+x_3=0
\end{matrix}
\Rightarrow
\textbf{v}_3=[\frac{4}{17}x_3, -\frac{5}{17}x_3, x_3]^T=\lambda[\frac{4}{17}, -\frac{5}{17}, 1]^T
$$
Hence the orthonormal set is
$$
\begin{bmatrix}
2\alpha & -3\beta & \frac{4}{17}\gamma\\
5\alpha & 1\beta & -\frac{5}{17}\gamma\\
1\alpha & 1\beta & 1\gamma\\
\end{bmatrix}
$$
for some $\alpha, \beta, \gamma\in \R$

### Solution 3

i) $\text{proj}_\textbf{u}(\textbf{v})$ represents the vector whose direction is the same with $\textbf{u}$ but the length is equal to the projection of $\textbf{v}$ on to $\textbf{u}$.

ii) To check that $\{\textbf{w}_i:i=1,2,3\}$ is an orthonormal basis for $\R^3$, we need to show that
$$
\textbf{w}_1\cdot \textbf{w}_2=0\\
\textbf{w}_1\cdot \textbf{w}_3=0\\
\textbf{w}_2\cdot \textbf{w}_3=0
$$
To check the relations above, we can instead use $\textbf{u}_1$, $\textbf{u}_2$, and $\textbf{u}_3$:
$$
\begin{matrix}
\textbf{u}_1\cdot \textbf{u}_2=0\\
\textbf{u}_1\cdot \textbf{u}_3=0\\
\textbf{u}_2\cdot \textbf{u}_3=0
\end{matrix}
\Rightarrow
\begin{matrix}
\textbf{v}_1\cdot (\textbf{v}_2-\text{proj}_{\textbf{v}_1}(\textbf{v}_2))=0\\
\textbf{v}_1\cdot (\textbf{v}_3-\text{proj}_{\textbf{v}_1}(\textbf{v}_3)-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))=0\\
(\textbf{v}_2-\text{proj}_{\textbf{v}_1}(\textbf{v}_2))\cdot (\textbf{v}_3-\text{proj}_{\textbf{v}_1}(\textbf{v}_3)-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))=0
\end{matrix}
$$
we then approach to the first equation
$$
\begin{align}
\textbf{v}_1\cdot (\textbf{v}_2-\text{proj}_{\textbf{v}_1}(\textbf{v}_2))&=\textbf{v}_1\cdot (\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\textbf{v}_1)\\
&=\textbf{v}_1\cdot \textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\textbf{v}_1\cdot \textbf{v}_1\\
&=\textbf{v}_1\cdot \textbf{v}_2-\textbf{v}_1\cdot \textbf{v}_2\\
&=0
\end{align}
$$
we then approach to the second equation
$$
\begin{align}
\textbf{v}_1\cdot (\textbf{v}_3-\text{proj}_{\textbf{v}_1}(\textbf{v}_3)-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))&=\textbf{v}_1\cdot \textbf{v}_3-\textbf{v}_1\cdot \text{proj}_{\textbf{v}_1}(\textbf{v}_3)-\textbf{v}_1\cdot \text{proj}_{\textbf{u}_2}(\textbf{v}_3)\\
&=\textbf{v}_1\cdot \textbf{v}_3-\textbf{v}_1\cdot \frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot\textbf{v}_1-\textbf{v}_1\cdot \text{proj}_{\textbf{u}_2}(\textbf{v}_3)\\
&=-\textbf{v}_1\cdot \text{proj}_{\textbf{u}_2}(\textbf{v}_3)\\
&=-\textbf{v}_1\cdot \frac{\textbf{u}_2\cdot \textbf{v}_3}{\textbf{u}_2\cdot \textbf{u}_2}\textbf{u}_2\\
&=-\textbf{u}_1\cdot \frac{\textbf{u}_2\cdot \textbf{v}_3}{\textbf{u}_2\cdot \textbf{u}_2}\textbf{u}_2 & \text{(follows the fact that $\textbf{u}_1=\textbf{v}_1$)}\\
&=0 & \text{(follows the fact that $\textbf{u}_1\cdot \textbf{u}_2=0$)}
\end{align}
$$
we then approach to the third equation
$$
\begin{align}
&(\textbf{v}_2-\text{proj}_{\textbf{v}_1}(\textbf{v}_2))\cdot (\textbf{v}_3-\text{proj}_{\textbf{v}_1}(\textbf{v}_3)-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))\\
=&(\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\textbf{v}_1)\cdot (\textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot\textbf{v}_1-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))\\
=&\textbf{v}_2(\textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot\textbf{v}_1-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\textbf{v}_1(\textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot\textbf{v}_1-\text{proj}_{\textbf{u}_2}(\textbf{v}_3))\\
=&\textbf{v}_2\cdot \textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_2\cdot \textbf{v}_1-\frac{(\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1)\cdot \textbf{v}_3}{(\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1)^2}\cdot (\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1)\cdot \textbf{v}_2\\
=&\textbf{v}_2\cdot \textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_2\cdot \textbf{v}_1-(\textbf{v}_2-\frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1)\cdot \textbf{v}_3\\
=&\textbf{v}_2\cdot \textbf{v}_3-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_2\cdot \textbf{v}_1-\textbf{v}_2\cdot \textbf{v}_3+\textbf{v}_3\cdot \frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1\\
=&\textbf{v}_3\cdot \frac{\textbf{v}_1\cdot \textbf{v}_2}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_1-\frac{\textbf{v}_1\cdot \textbf{v}_3}{\textbf{v}_1\cdot \textbf{v}_1}\cdot \textbf{v}_2\cdot \textbf{v}_1\\
=&0
\end{align}
$$
iii) We can obtain an orthonormal basis by executing the following procedure:
$$
\textbf{w}_i=\textbf{v}_i-\sum_{k=1}^{i-1}\text{proj}_{\textbf{u}_k}(\textbf{v}_i)
$$

### Solution 4

- The matrix representing $f$ is as follows:

$$
\textbf{A}=
\begin{bmatrix}
5 & 3\\
-6& 1
\end{bmatrix}
$$

- The coordinate of $\textbf{v}$ with respect to the basis $\textbf{e}_1$ and $\textbf{e}_2$ is therefore $[2,-1]$. Using matrix $\textbf{A}$ we can find the value of $f(\textbf{v})$:

$$
f(\textbf{v})=
\begin{bmatrix}
5 & 3\\
-6 & 1
\end{bmatrix}
\begin{bmatrix}
2\\
-1
\end{bmatrix}
=
\begin{bmatrix}
7\\
-13
\end{bmatrix}
$$

- We can now plug in $\textbf{d}_1$ and $\textbf{d}_2$ with $f$:

$$
f(\textbf{d}_1)=f(\textbf{e}_1)-f(\textbf{e}_2)=2\textbf{e}_1-7\textbf{e}_2\\
f(\textbf{d}_1)=f(\textbf{e}_1)+f(\textbf{e}_2)=8\textbf{e}_1-5\textbf{e}_2
$$

​		Then the transformation matrix is
$$
\Phi_{ED}=\begin{bmatrix}
2 & 8\\
-7 & -5
\end{bmatrix}
$$

### Solution 5

i) We first need to show that the mapping is well-defined by showing
$$
(c_1\textbf{w}_1+c_2\textbf{w}_2)\cdot f^*(\textbf{v})=c_1\textbf{w}_1\cdot f^*(\textbf{v})+c_2\textbf{w}_2\cdot f^*(\textbf{v})
$$
This can be proved by expanding the left hand side:
$$
\begin{align}
(c_1\textbf{w}_1+c_2\textbf{w}_2)\cdot f^*(\textbf{v})&=\textbf{v}\cdot f(c_1\textbf{w}_1+c_2\textbf{w}_2)\\
&=\textbf{v}\cdot (c_1f(\textbf{w}_1)+c_2f(\textbf{w}_2))\\
&=c_1\textbf{v}\cdot f(\textbf{w}_1)+c_2\textbf{v}\cdot f(\textbf{w}_2)\\
&=c_1\textbf{w}_1\cdot f^*(\textbf{v})+c_2\textbf{w}_2\cdot f^*(\textbf{v})
\end{align}
$$
For the linearity of this mapping, we need to show that
$$
f^*(a\textbf{p}+b\textbf{q})=af^*(\textbf{p})+bf^*(\textbf{q})
$$
for some vector $\textbf{p}\in \R^n$ and $\textbf{q}\in\R^m$, $a, b\in \R$.

Using the given form of the mapping definition, we can first prove that
$$
\textbf{u}\cdot f^*(a\textbf{p}+b\textbf{q})=\textbf{u}\cdot (af^*(\textbf{p})+bf^*(\textbf{q}))
$$
for some vector $\textbf{u}\in \R^n$.

Again, we expand the left hand side:
$$
\begin{align}
\textbf{u}\cdot f^*(a\textbf{p}+b\textbf{q})&=(a\textbf{p}+b\textbf{q})\cdot f(\textbf{u})\\
&=a\textbf{p}f(\textbf{u})+b\textbf{q}f(\textbf{u})\\
&=a\textbf{u}f^*(\textbf{p})+b\textbf{u}f^*(\textbf{q})\\
&=\textbf{u}\cdot (af^*(\textbf{p})+bf^*(\textbf{q}))
\end{align}
$$
which has proved the linearity of $f^*$.

ii) 



