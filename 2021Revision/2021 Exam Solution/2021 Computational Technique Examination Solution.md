# 2021 Computational Technique Examination Solution

*Disclaimer: this solution only serves as a reference. Some answer may be incorrect or insufficient. If you think something is wrong just send me a message or leave a comment :)*

*Another thing to mention: I'm really surprised by how much we have to write just in this time frame and I only finished like half of the paper :)))). This is not cool :))*

1. a. i) We first find the matrix $A^TA$ which has a smaller dimension than $AA^T$
   $$
   A^TA=\begin{bmatrix}
   3 & 2 & 2\\
   2 & 3 & -2
   \end{bmatrix}
   \begin{bmatrix}
   3 & 2\\
   2 & 3\\
   2 & -2
   \end{bmatrix}=\begin{bmatrix}
   17 & 8\\
   8 & 17
   \end{bmatrix}
   $$
   ​		We then find the spectral decomposition of $A^TA$ using its eigenvalues and eigenvectors. First we find the eigenvalues and eigenvectors of $A^TA$ by letting $\det(A^TA-\lambda I)=0$
   $$
   \begin{vmatrix}
   17-\lambda & 8\\
   8 & 17-\lambda
   \end{vmatrix}=0\Rightarrow \begin{align}(17-\lambda)^2&=64\\
   17-\lambda&=\pm8\\
   \lambda&=25, 9
   \end{align}
   $$
   ​		Hence, $\lambda_1=25$, $\lambda_2=9$. We then find the corresponding eigenvectors:
   $$
   E_{25}=\begin{bmatrix}
   1\\1
   \end{bmatrix},E_9=\begin{bmatrix}
   1\\-1
   \end{bmatrix}
   $$
   ​		Therefore we have the orthogonal matrix $V$:
   $$
   V=\frac{1}{\sqrt{2}}\begin{bmatrix}
   1&1\\
   1&-1
   \end{bmatrix}
   $$
   ​		after normalization.

   ​		We use the fact that $US=AV$ to find $U$
   $$
   u_1=\frac{1}{\sigma_1}Av_1=\frac{1}{\sqrt{25}}\cdot\frac{1}{\sqrt{2}}\begin{bmatrix}
   5\\5\\0
   \end{bmatrix}=\frac{1}{\sqrt{2}}\begin{bmatrix}
   1\\1\\0
   \end{bmatrix}\\
   u_2=\frac{1}{\sigma_2}Av_2=\frac{1}{\sqrt{9}}\cdot \frac{1}{\sqrt{2}}\begin{bmatrix}
   1\\-1\\4
   \end{bmatrix}=\frac{1}{3\sqrt{2}}\begin{bmatrix}
   1\\-1\\4
   \end{bmatrix}\\
   u_3=u_1\times u_2=\begin{vmatrix}
   i & j & k\\
   \frac{1}{\sqrt{2}} & \frac{1}{\sqrt{2}} & 0\\
   \frac{1}{3\sqrt{2}} & -\frac{1}{3\sqrt{2}} & \frac{4}{3\sqrt{2}}
   \end{vmatrix}=\begin{bmatrix}
   \frac{2}{3}\\-\frac{2}{3}\\-\frac{1}{3}
   \end{bmatrix}=\frac{1}{3}\begin{bmatrix}
   2\\-2\\-1
   \end{bmatrix}
   $$
   ​		Hence we have the SVD of $A$
   $$
   A=USV^T=\frac{1}{3\sqrt{2}}\begin{bmatrix}
   \frac{3}{\sqrt{2}} & \frac{1}{\sqrt{2}} & 2\\
   \frac{3}{\sqrt{2}} & -\frac{1}{\sqrt{2}} & -2\\
   0 & 2\sqrt{2} & -1
   \end{bmatrix}\begin{bmatrix}
   5 & 0\\
   0 & 3\\
   0 & 0
   \end{bmatrix}
   \begin{bmatrix}
   1 & 1\\
   1 & -1
   \end{bmatrix}
   $$
   ​	ii) In principal component analysis, we have
   $$
   w=\arg\max_{\lVert w\rVert=1}\{w^TA^TAw\}=v_1
   $$
   ​		where $v_1=\frac{1}{\sqrt{2}}\begin{bmatrix}1\\1\end{bmatrix}$ which we have foudn in 1a i)

   ​	iii) Using SVD we have
   $$
   A=\sigma_1u_1v_1^T+\sigma_2u_2v_2^T=\frac{5}{2}\begin{bmatrix}
   1 & 1\\
   1 & 1\\
   0 & 0
   \end{bmatrix}+\frac{3}{6}\begin{bmatrix}
   1 & -1\\
   -1 & 1\\
   4 & -4
   \end{bmatrix}
   $$
   ​		Both matrix have rank one as both of them have two rows that are the linear combination of the other row. (or columnwise: both columns are multiple of each other)

   b. Matrix $B$ does not have a cholesky decomposition. To find the cholesky decomposition of $A$ (there are different solutions):
   $$
   A=LL^T=\begin{bmatrix}
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
   ​	From the corresponding values in matrix $A$ we know that
   $$
   l_{11}^2=25\Rightarrow l_{11}=5\\
   l_{11}l_{21}=15\Rightarrow l_{21}=\frac{15}{5}=3\\
   l_{11}l_{31}=-5\Rightarrow l_{31}=\frac{-5}{5}=-1\\
   l_{21}^2+l_{22}^2=18\Rightarrow l_{22}=\sqrt{18-9}=3\\
   l_{21}l_{31}+l_{22}l_{32}=0\Rightarrow l_{32}=1\\
   l_{31}^2+l_{32}^2+l_{33}^2=11\Rightarrow l_{11}=3
   $$
   ​	Hence we have
   $$
   L=\begin{bmatrix}
   5 & 0 & 0\\
   3 & 3 & 0\\
   -1 & 1 & 3
   \end{bmatrix}
   $$
   c. We first try to find the eigenvectors of $A$ by letting its characteristic polynomial equal to 0
   $$
   \begin{align}
   (3-\lambda)(4-\lambda)(2-\lambda)+3=0\\
   -(\lambda-3)^3=0\\
   \lambda=3
   \end{align}
   $$
   ​	Hence the algebraic multiplicity of $\lambda$ is 3. However, the geometric multiplicity of $\lambda $ is 2:
   $$
   (A-3I)x=0\Rightarrow x=\text{span}\begin{pmatrix}
   \begin{bmatrix}
   0\\1\\1
   \end{bmatrix},
   \begin{bmatrix}
   1\\0\\0
   \end{bmatrix}
   \end{pmatrix}
   $$
   ​	Therefore, $A$ is not diagnolisable since it has an eigenvalue whose algebraic multiplicity is not equal to its geometric multiplicity.

   ​	The JNF of $A$ is
   $$
   A=SJS^{-1}=\begin{bmatrix}
   0 & 0 & 1\\
   1 & 1 & 0\\
   1 & 0 & 0
   \end{bmatrix}
   \begin{bmatrix}
   3 & 1 & 0\\
   0 & 3 & 0\\
   1 & 0 & 3
   \end{bmatrix}\begin{bmatrix}
   0 & 0 & 1\\
   0 & 1 & -1\\
   1 & 0 & 0
   \end{bmatrix}
   $$
   ​	where $S$ is the basis we need to find out. Notice that reordering the columns can produce different results.

   d. To show that $u$ is an eigenvector of $A=uv^T$, we need to show that $Au=\lambda u$ 
   $$
   Au=uv^Tu=u(v^Tu)=(v^Tu)u
   $$
   ​	Since $u,$$v\in \R^3$, we know that $v^Tu$ is a scalar and hence we can let $\lambda =(v^Tu)$ to prove that $u$ is an eigenvector of $A$

   ​	To find other eigenvalues (maximum is 3 since it's 3 dimensional), we can use the fact that
   $$
   \det(A)=v^Tu\cdot \lambda_2\cdot \lambda_3\\
   \text{trace}(A)=v^Tu+\lambda_2+\lambda_3
   $$
   ​	Since $A=uv^T$, the sum of the diagnol elements equal to $v^Tu$ and hence
   $$
   \begin{align}
   \text{trace}(A)=v^Tu&=v^Tu+\lambda_2+\lambda_3\\
   0&=\lambda_2+\lambda_3\\
   \lambda_2&=-{\lambda_3}
   \end{align}
   $$
   ​	Hence the other two eigenvalues are $\lambda_2=\sqrt{-\frac{\det(A)}{v^Tu}}=\sqrt{\frac{\det(A)}{v^Tu}}i$ and $\lambda_3=-\sqrt{\frac{\det(A)}{v^Tu}}i$

2. a. i) Using the $l_1$ norm we have
   $$
   \text{cond}(A)=\lVert A\rVert_1\lVert A^{-1}\rVert_1=18\cdot\frac{164}{152}\approx19.42
   $$
   ​		Using $l_\infin$ norm we have
   $$
   \text{cond}(A)=\lVert A\rVert_\infin\lVert A^{-1}\rVert_\infin=18\cdot \frac{164}{152}\approx 19.42
   $$
   ​		Using $l_2$ norm we have
   $$
   \text{cond}(A)=\lVert A\rVert_2\lVert A^{-1}\rVert_2=15.5994\cdot \frac{1}{1.15373}=13.52
   $$
   ​		using the fact that the eigenvalues of $A^{-1}$ is the inverse of eigenvalues of $A$

   b. i) Below is the proof
   $$
   \lVert \sum_{i=m+1}^{n}\frac{M^it^i}{i!}\rVert=\sum_{i=m+1}^{n}\frac{\lVert M^i\rVert t^i}{i!}\le\sum_{i=m+1}^{n}\frac{\lVert M\rVert^i t^i}{i!} 
   $$
   ​		assuming that the norm is subordinate and thus $\lVert AB\rVert\le \lVert A\rVert\lVert B\rVert$

   ​	ii) Let $m<n<N$ for some large number $N\in \R$. Since we know that the exponential series defined on real numbers is convergent, we thus know that for any $x\in\R$
   $$
   \lim_{n\rightarrow \infin}\frac{x^n}{n!}=0
   $$
    		We can then set $x=\lVert M\rVert t$ and thus $\lim_{i\rightarrow\infin}\frac{(\lVert M\rVert t)^i}{i!}=0$. For sufficiently large number $m<n<N$, we have
   $$
   \lim_{m,n\rightarrow\infin}\sum_{i=m+1}^{n}\frac{\lVert M\rVert^it^i}{i!}=\lim_{m,n\rightarrow\infin}(\sum_{i=0}^{n}\frac{\lVert M\rVert^it^i}{i!}-\sum_{i=0}^{m}\frac{\lVert M\rVert^it^i}{i!})=e^{\lVert M\rVert t}-e^{\lVert M\rVert t}=0
   $$
   ​	iii) The proof is shown below
   $$
   \begin{align}
   \lVert e^{Mt}\rVert=\lVert\sum_{i=0}^{\infin}\frac{M^it^i}{i!}\rVert&\le \sum_{i=0}^{\infin}\frac{\lVert M\rVert^it^i}{i!} & (\text{From i})\\
   &=e^{\lVert M\rVert t} & (\text{From the definition of exponential series})
   \end{align}
   $$
   ​	iv) The proof of $\frac{d}{dt}e^{Mt}=Me^{Mt}$ is as follows
   $$
   \begin{align}
   \frac{d}{dt}e^{Mt}=\frac{d}{dt}(\sum_{i=0}^{\infin}\frac{M^it^i}{i!})&=\frac{d}{dt}(I+Mt+\frac{M^2t^2}{2!}+\frac{M^3t^3}{3!}+...)\\
   &=\textbf{0}+M+tM^2+\frac{t^2M^3}{2!}+...\\
   &=M(I+tM+\frac{t^2M^2}{2!}+...)\\
   &=M\sum_{i=0}^{\infin}\frac{M^it^i}{i!}=Me^{Mt}
   \end{align}
   $$
   ​		We can plug in $\vec{f}(t)=e^{Mt}\vec{f}(0)$ in to the differential equation to verify
   $$
   \begin{align}
   \frac{d}{dt}(e^{Mt}\vec{f}(0))&=Me^{Mt}\vec{f}(0)+e^{Mt}\cdot 0\\
   &=Me^{Mt}\vec{f}(0)\\
   &=M\vec{f}(0)
   \end{align}
   $$
   ​	v) This question is supposed to relate to iv) but who knows :)

   ​		The answer is as follows
   $$
   y_1(t)=\frac{1}{2}e^{3t}+\frac{1}{2}e^{-3t}\\
   y_2(t)=\frac{1}{6}e^{3t}-\frac{1}{6}e^{-3t}
   $$
   c. The coefficient can be found as follows
   $$
   \begin{align}
   a_k&=\frac{1}{2}(\int_{0}^{1}xe^{-i\pi kx}dx+\int_{1}^{2}(2-x)e^{-i\pi kx}dx)\\
   &=\frac{1}{2}(-\frac{1}{\pi k i}+2\int_1^2e^{-i\pi kx}dx-\int_1^2xe^{-i\pi kx}dx)\\
   &=\frac{1}{2}(-\frac{1}{\pi ki}+2\frac{i}{\pi k}(e^{-2i\pi k}-e^{-i\pi k})-(-3e^{-2i\pi k}+2e^{-i\pi k}))\\
   &=-\frac{1}{2\pi ki}+\frac{i}{\pi k}((-1)^{2k}-(-1)^k)-\frac{1}{2}(-3\cdot (-1)^{2k}+2\cdot (-1)^k)\\
   &=-\frac{1}{2\pi ki}-(-1)^k\frac{i}{\pi k}+\frac{3}{2}-(-1)^k
   \end{align}
   $$
   

