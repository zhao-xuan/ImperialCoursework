# Computational Techniques Coursework 6

### Solution 1

We perform six iterations of the power method using $l_1$ norm
$$
\begin{align}
x_1&=\frac{Ax_0}{\lVert Ax_0\rVert}=\frac{1}{14}\begin{bmatrix}-10\\-4\end{bmatrix}=\begin{bmatrix}-\frac{5}{7}\\-\frac{2}{7}\end{bmatrix}\\

x_2&=\frac{Ax_1}{\lVert Ax_1\rVert}=\frac{7}{19}\begin{bmatrix}2\\\frac{5}{7}\end{bmatrix}=\begin{bmatrix}\frac{14}{19}\\\frac{5}{19}\end{bmatrix}\\

x_3&=\frac{Ax_2}{\lVert Ax_2\rVert}=\frac{19}{43}\begin{bmatrix}-\frac{32}{19}\\-\frac{11}{19}\end{bmatrix}=\begin{bmatrix}-\frac{32}{43}\\-\frac{11}{43}\end{bmatrix}\\

x_4&=\frac{Ax_3}{\lVert Ax_3\rVert}=\frac{43}{91}\begin{bmatrix}\frac{68}{43}\\\frac{23}{43}\end{bmatrix}=\begin{bmatrix}\frac{68}{91}\\\frac{23}{91}\end{bmatrix}\\

x_5&=\frac{Ax_4}{\lVert Ax_4\rVert}=\frac{91}{187}\begin{bmatrix}-\frac{140}{91}\\-\frac{47}{91}\end{bmatrix}=\begin{bmatrix}-\frac{140}{187}\\-\frac{47}{187}\end{bmatrix}\\

x_6&=\frac{Ax_5}{\lVert Ax_5\rVert}=\frac{187}{379}\begin{bmatrix}\frac{284}{187}\\\frac{95}{187}\end{bmatrix}=\begin{bmatrix}\frac{284}{379}\\\frac{95}{379}\end{bmatrix}\\

\end{align}
$$
Hence the estimated dominant eigenvector of $A$ is $\begin{bmatrix}\frac{284}{379}\\\frac{95}{379}\end{bmatrix}\approx \begin{bmatrix}0.75\\0.25\end{bmatrix}$

In the last iterationm we use the value of $x_6$ to approximate the dominant eigenvalue
$$
\sigma=\frac{x_6^TAx_6}{x_6^Tx_6}=-\frac{180593}{89681}\approx-2.014\\
|\lambda_{\text{dominant}}|\approx 2.014
$$

### Solution 2

We perform seven iterations of the power method using $l_\infin$ norm instead
$$
\begin{align}
x_1&=\frac{Ax_0}{\lVert Ax_0\rVert}=\frac{1}{5}\begin{bmatrix}3\\1\\5\end{bmatrix}=\begin{bmatrix}\frac{3}{5}\\\frac{1}{5}\\1\end{bmatrix}\\

x_2&=\frac{Ax_1}{\lVert Ax_1\rVert}=\frac{5}{11}\begin{bmatrix}1\\1\\\frac{11}{5}\end{bmatrix}=\begin{bmatrix}\frac{5}{11}\\\frac{5}{11}\\1\end{bmatrix}\\

x_3&=\frac{Ax_2}{\lVert Ax_2\rVert}=\frac{11}{31}\begin{bmatrix}\frac{15}{11}\\\frac{17}{11}\\\frac{31}{11}\end{bmatrix}=\begin{bmatrix}\frac{15}{31}\\\frac{17}{31}\\1\end{bmatrix}\\

x_4&=\frac{Ax_3}{\lVert Ax_3\rVert}=\frac{31}{97}\begin{bmatrix}\frac{49}{31}\\\frac{18}{31}\\\frac{97}{31}\end{bmatrix}=\begin{bmatrix}\frac{49}{97}\\\frac{18}{97}\\1\end{bmatrix}\\

x_5&=\frac{Ax_4}{\lVert Ax_4\rVert}=\frac{97}{200}\begin{bmatrix}\frac{85}{97}\\\frac{114}{97}\\\frac{200}{97}\end{bmatrix}=\begin{bmatrix}\frac{85}{200}\\\frac{114}{200}\\1\end{bmatrix}\\

x_6&=\frac{Ax_5}{\lVert Ax_5\rVert}=\frac{200}{627}\begin{bmatrix}\frac{313}{200}\\\frac{344}{200}\\\frac{627}{200}\end{bmatrix}=\begin{bmatrix}\frac{313}{627}\\\frac{344}{627}\\1\end{bmatrix}\\

x_7&=\frac{Ax_6}{\lVert Ax_6\rVert}=\frac{627}{1972}\begin{bmatrix}\frac{1001}{627}\\\frac{772}{627}\\\frac{1972}{627}\end{bmatrix}=\begin{bmatrix}\frac{1001}{1972}\\\frac{772}{1972}\\1\end{bmatrix}\\
\end{align}
$$
The approximate dominant eigenvector is $\begin{bmatrix}0.5\\0.5\\1\end{bmatrix}$

### Solution 3

We first prove the Sherman-Morrison formula directly by multiplying $(\textbf{A}+\textbf{uv}^T)$ on the right hand side
$$
\begin{align}
(\textbf{A}^{-1}-\frac{\textbf{A$^{-1}$uv$^T$A$^{-1}$}}{1+\textbf{v$^T$A$^{-1}$u}})(\textbf{A}+\textbf{uv}^T)&=\textbf{A$^{-1}$}(\textbf{A}+\textbf{uv}^T)-\frac{\textbf{A$^{-1}$uv$^T$A$^{-1}$}}{1+\textbf{v$^T$A$^{-1}$u}}(\textbf{A}+\textbf{uv}^T)\\
&=\textbf{A$^{-1}$A}+\textbf{A$^{-1}$uv}^T-\frac{\textbf{A$^{-1}$uv$^T$A$^{-1}$A}}{1+\textbf{v$^T$A$^{-1}$u}}-\frac{\textbf{A$^{-1}$uv$^T$A$^{-1}$uv$^T$}}{1+\textbf{v$^T$A$^{-1}$u}}\\
&=\textbf{I}+\textbf{A$^{-1}$uv$^T$}-\frac{\textbf{A$^{-1}$uv$^T$}}{1+\textbf{v$^T$A$^{-1}$u}}-\frac{(\textbf{A$^{-1}$uv$^T)($A$^{-1}$uv$^T$})}{1+\textbf{v$^T$A$^{-1}$u}}\\
&=\textbf{I}+\frac{(\textbf{A$^{-1}$uv$^T$})(1+\textbf{v$^T$A$^{-1}$u})}{1+\textbf{v$^T$A$^{-1}$u}}-\frac{(\textbf{A$^{-1}$uv$^T$})(1+\textbf{v$^T$A$^{-1}$u})}{1+\textbf{v$^T$A$^{-1}$u}}\\
&=\textbf{I}
\end{align}
$$
which is exactly the same result we get when we multiply $(\textbf{A+uv}^T)$ to the left hand side
$$
(\textbf{A+uv}^T)^{-1}(\textbf{A+uv}^T)=\textbf{I}
$$
The same result follows if we multiply the right hanside like this
$$
(\textbf{A}+\textbf{uv}^T)(\textbf{A}^{-1}-\frac{\textbf{A$^{-1}$uv$^T$A$^{-1}$}}{1+\textbf{v$^T$A$^{-1}$u}})=\textbf{I}
$$
a) In the Sherman-Morrison formula, we let $\textbf{A}=\textbf{I}$ and we can easily get the result
$$
\begin{align}
(\textbf{I}+\textbf{uv}^T)^{-1}&=\textbf{I}^{-1}-\frac{\textbf{I$^{-1}$uv$^T$I$^{-1}$}}{1+\textbf{v$^T$I$^{-1}$u}}\\
&=\textbf{I}-\frac{\textbf{uv}^T}{1+\textbf{v$^T$u}}
\end{align}
$$
b) In the equation we have just proved in a), we further choose $\textbf{v}=-\frac{2}{\textbf{u$^T$u}}\textbf{u}$. Them the left hand side becomes
$$
\begin{align}
(\textbf{I}+\textbf{uv}^T)^{-1}&=(\textbf{I}+\textbf{u}(\frac{-2}{\textbf{u$^T$u}}\textbf{u})^T)^{-1}\\
&=(\textbf{I}+(\frac{-2}{\textbf{u$^T$u}})\textbf{uu}^T)^{-1}\\
&=(\textbf{I}-2\frac{\textbf{uu}^T}{\textbf{u$^T$u}})^{-1}
\end{align}
$$
​	and the right hand side becomes
$$
\begin{align}
\textbf{I}-\frac{\textbf{uv}^T}{1+\textbf{v$^T$u}}&=\textbf{I}-\frac{\textbf{u}(\frac{-2}{\textbf{u$^T$u}}\textbf{u})^T}{1+(\frac{-2}{\textbf{u$^T$u}}\textbf{u})^T\textbf{u}}\\
&=\textbf{I}-\frac{(\frac{-2}{\textbf{u$^T$u}})\textbf{uu}^T}{1+\frac{-2}{\textbf{u$^T$u}}\textbf{u$^T$u}}\\
&=\textbf{I}-\frac{(\frac{-2}{\textbf{u$^T$u}})\textbf{uu}^T}{1-2}\\
&=\textbf{I}-2\frac{\textbf{uu}^T}{\textbf{u$^T$u}}\\
\end{align}
$$
c) Let $\textbf{w}=\textbf{Au}$ and hence $\textbf{A}+\textbf{wv}^T=\textbf{A}(\textbf{I}+\textbf{uv}^T)$

We plug in those equations into a)
$$
\begin{align}
(\textbf{A}+\textbf{wv}^T)^{-1}&=(\textbf{A}(\textbf{I}+\textbf{uv}^T))^{-1}\\
&=(\textbf{I}+\textbf{uv}^T)^{-1}\textbf{A}^{-1} & \text{(By the fact that $(\textbf{AB})^{-1}=\textbf{B}^{-1}\textbf{A}^{-1}$)}\\
&=(\textbf{I}-\frac{\textbf{uv}^T}{1+\textbf{v}^T\textbf{u}})\textbf{A}^{-1} & \text{(From a)}\\
&=\textbf{A}^{-1}-\frac{\textbf{uv$^T$A$^{-1}$}}{1+\textbf{v$^T$u}}\\
&=\textbf{A}^{-1}-\frac{\textbf{A$^{-1}$wv$^T$A$^{-1}$}}{1+\textbf{v$^T$A$^{-1}$w}} & \text{(By substituting $\textbf{u}$ with $\textbf{A$^{-1}$w}$)}
\end{align}
$$
which has proved the Sherman-Morrison formula