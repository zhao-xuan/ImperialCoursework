# Probability and Stats Assessed Coursework Jointly Distributed Random Variables

### Solution 1

a) Since the integration over the joint pdf must equal to 0, we have
$$
\begin{align}
\int_{x=0}^{2}\int_{y=0}^{2}k(x+y)dydx&=1\\
\int_{x=0}^{2}(2kx+2k)dx&=1\\
4k+4k&=1\\
k&=\frac{1}{8}
\end{align}
$$
b) The marginal pdfs of $X$ and $Y$ can be found as follows
$$
\begin{align}
p_X(x)&=\int_{y=-\infin}^{\infin}f(x,y)dy=\int_{0}^{2}\frac{1}{8}(x+y)dy=\frac{1}{4}x+\frac{1}{4}, 0<x<2\\
p_Y(y)&=\int_{x=-\infin}^{\infin}f(x,y)dx=\int_{0}^{2}\frac{1}{8}(x+y)dx=\frac{1}{4}y+\frac{1}{4}, 0<y<2
\end{align}
$$
c) From b) we know that
$$
p_X(x)p_Y(y)=(\frac{1}{4}x+\frac{1}{4})(\frac{1}{4}y+\frac{1}{4})=\frac{1}{16}(xy+x+y+1)\ne f(x,y)
$$
​	which means that $X$ and $Y$ are NOT independent.

### Solution 2

We can determine $P(X>Y)$ as follows
$$
\begin{align}
P(X>Y)=\int_{x=-\infin}^{\infin}\int_{y=-\infin}^{x}f(x,y)dydx&=\int_{x=0}^{\infin}\int_{y=0}^{x}abe^{-(ax+by)}dydx\\
&=\int_{x=0}^{\infin}a(e^{-ax}-e^{-(a+b)x})dx\\
&=1-\frac{a}{a+b}=\frac{b}{a+b}=\frac{6}{11}
\end{align}
$$

### Solution 3

a) The total integration of the pmf must be 1, hence we have
$$
\begin{align}
\sum_{i=1}^{3}\sum_{j=1}^{3}cx_iy_j=1\\
\sum_{i=1}^{3}6cx_i=1\\
36c=1\\
c=\frac{1}{36}
\end{align}
$$
b) $P(X=2, Y=3)=\frac{1}{36}\cdot 2\cdot 3=\frac{1}{6}$

c) $P(X\le 2, Y\le 2)=\frac{1}{36}(1\cdot 1+1\cdot 2+2\cdot 1+2\cdot 2)=\frac{1}{4}$

d) $P(X\ge 2)=\frac{1}{36}(2+3)(1+2+3)=\frac{5}{6}$

e) $P(Y<2)=\frac{1}{36}(1+2+3)=\frac{1}{6}$

f) $P(X=1)=\frac{1}{36}(1+2+3)=\frac{1}{6}$

g) $P(Y=3)=\frac{1}{36}\cdot 3\cdot (1+2+3)=\frac{1}{2}$

### Solution 4

a) Again, the total area/integration of pdf has to be 1
$$
\begin{align}
\int_{x=-\infin}^{\infin}\int_{y=-\infin}^{\infin}f(x,y)dydx=1\\
\int_{x=0}^{1}\int_{y=0}^{1}c(x^2+y^2)dydx=1\\
\int_{x=0}^{1}c(x^2+\frac{1}{3})dx=1\\
\frac{2}{3}c=1\\
c=\frac{3}{2}
\end{align}
$$
b) $P(X<\frac{1}{2}, Y>\frac{1}{2})=\int_{x=0}^{\frac{1}{2}}\int_{y=\frac{1}{2}}^{1}\frac{3}{2}(x^2+y^2)dydx=\frac{3}{2}\int_{x=0}^{\frac{1}{2}}\frac{1}{2}x^2+\frac{7}{24}dx=\frac{1}{4}$

c) $P(\frac{1}{4}<X<\frac{3}{4})=\int_{x=\frac{1}{4}}^{\frac{3}{4}}\int_{y=0}^{1}\frac{3}{2}(x^2+y^2)dydx=\frac{3}{2}\int_{x=\frac{1}{4}}^{\frac{3}{4}}x^2+\frac{1}{3}dx=\frac{29}{64}$

d) $P(Y<\frac{1}{2})=\frac{3}{2}\int_{x=0}^{1}\int_{y=0}^{\frac{1}{2}}(x^2+y^2)dydx=\frac{3}{2}\int_{x=0}^{1}\frac{1}{2}x^2+\frac{1}{24}dx=\frac{5}{16}$

e) We know that
$$
\begin{align}
p_X(x)&=\int_{y=0}^{1}\frac{3}{2}(x^2+y^2)dy=\frac{3}{2}x^2+\frac{1}{2}\\
p_Y(y)&=\int_{x=0}^{1}\frac{3}{2}(x^2+y^2)dx=\frac{3}{2}y^2+\frac{1}{2}\\
p_X(x)p_Y(y)&=(\frac{3}{2}x^2+\frac{1}{2})(\frac{3}{2}y^2+\frac{1}{2})=\frac{1}{4}(9x^2y^2+3x^2+3y^2+1)\ne f(x,y)
\end{align}
$$
​	Hence $X$ and $Y$ are not independent.

### Solution 5

a) Using the cdf of $X$ and $Y$ we can find that
$$
\begin{align}
P(X<Y+1)&=\int_{y=-\infin}^{\infin}\int_{x=-\infin}^{y+1}f_{XY}(x,y)dxdy\\
&=\int_{y=-\infin}^{\infin}\int_{x=-\infin}^{y+1}f_X(x)f_Y(y)dxdy & \text{($X$ and $Y$ are independent)}\\
&=\int_{y=-\infin}^{\infin}\int_{x=-\infin}^{y+1}f_{X|Y}(x|y)f_Y(y)dxdy & \text{(By the partition rule of joint RV)}\\
&=\int_{y=-\infin}^{\infin}F_{X|Y}(y+1|y)f_Y(y)dy\\
&=\int_{y=-\infin}^{\infin}P(X<y+1|Y=y)f_Y(y)dy & \text{(By the definition of cdf)}
\end{align}
$$
b) The probability of $X<Y+1$ is
$$
\begin{align}
P(X<Y+1)&=\int_{-\infin}^{\infin}P(X<y+1|Y=y)f_Y(y)dy\\
&=\int_{-\infin}^{\infin}(\int_{-\infin}^{y+1}f_X(x)dx)f_Y(y)dy\\
&=\int_{-1}^{\infin}(\int_{0 }^{y+1}\lambda e^{-\lambda x}dx)f_Y(y)dy\\
&=\int_{-1}^{\infin}(1-e^{-\lambda (y+1)})(\frac{1}{\sqrt{2 \pi}}e^{-\frac{y^2}{2}})dy\\
&=\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{y^2}{2}}dy-\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{y^2}{2}-\lambda y-\lambda}dy\\
&=1-\Phi(-1)-\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{y^2}{2}-\lambda y-\lambda}dy\\
&=\Phi(1)-\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{y^2}{2}-\lambda y-\lambda}dy
\end{align}
$$
​	When $\lambda =1$, $P(X<Y+1)=\Phi(1)-\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{y^2}{2}-y-1}dy=\Phi(1)-\frac{1}{\sqrt{2\pi}}\cdot \sqrt{\frac{\pi}{2e}}=\Phi(1)-\frac{1}{2\sqrt{e}}$

### Solution 6

a) $T_n\le x$ indicates that the $n$th occurance is within time length $x$, which means that there must be at least $n$ occurances of the event within time period $x$. This is exactly the meaning of $N_x\ge n$.

b) With rate $\mu$ and time period of length $x$, the average number of events generated is thus $\mu x$

Since $T_n\le x\Leftrightarrow N_x\ge n$, we have $P(T_n\le x)=P(N_x\ge n)$.
$$
P(N_x\ge n)=1-P(N_x<n)=1-\sum_{k=0}^{n-1}\frac{e^{-\mu x}(\mu x)^k}{k!}=1-e^{-\mu x}\sum_{k=0}^{n-1}\frac{(\mu x)^k}{k!}
$$
c) Assume that the arrival of red bus and green bus are independent. Let $X$ be the time needed for a red bus to come next, and $Y$ be the time needed for a green bus to come next. We need to find $P(X<Y)$
$$
\begin{align}
P(X<Y)&=\int_{0}^{5}f_R(x)dx+\int_{y=5}^{\infin}\int_{x=5}^{y}f_R(x)f_R(y)dxdy\\
&=\int_{0}^{5}\lambda e^{-\lambda x}dx+\int_{y=5}^{\infin}\int_{x=5}^{y}(\lambda e^{-\lambda x})(\mu e^{-\mu (y-5)})dxdy\\
&=(1-e^{-5\lambda})+\int_{y=5}^{\infin}(-\mu e^{-\lambda y-\mu y+5\mu }+\mu e^{-5\lambda -\mu y+5\mu})dy\\
&=1-e^{-5\lambda}-\frac{\lambda e^{-5\lambda}}{\lambda +\mu}\\
&= 1-\frac{2\lambda +\mu}{\lambda+\mu}e^{-5\lambda}
\end{align}
$$

### Solution 7

a) Let $Q$ be the the random varaible of the number of minutes that the professor being late. Then we need to find $P(Q>m)$

​	According to the partition rule of random variable
$$
\begin{align}
P(Q>m)&=P(Q> m)\\

&=P(Z<-1)P(X> m)+P(Z\ge -1)P(Y>m)\\

&=\int_{-\infin}^{-1}\frac{1}{\sqrt{2\pi}}e^{-\frac{z^2}{2}}dz\int_{m}^{\infin}0.1e^{-0.1x}dx+\int_{-1}^{\infin}\frac{1}{\sqrt{2\pi}}e^{-\frac{z^2}{2}}dz\int_{m}^{\infin}0.05e^{-0.05x}dx\\
&=0.15865\cdot e^{-0.1m}+(1-0.15865)\cdot e^{-0.05m}\\
&=0.15865\cdot e^{-0.1m}+0.84134\cdot e^{-0.05m}
\end{align}
$$

b) The probability that the professor arrives at Victoria before 07:30 is $P(Z<-7)$
$$
P(Z<-7)=\int_{-\infin}^{-7}p_Z(x)dx=3.208\cdot 10^{-12}
$$

### Solution 8

The definition of joint probability distribution is as follows
$$
P_{XY}(B_X, B_Y)=P(X(s)\in B_X\and Y(s)\in B_Y| s\in S)
$$

