# Probability and Stats Exercise 3 - Continuous Random Variables

### Solution 1

Since the function satisfies $f(-x)=f(x)$, we know that
$$
\begin{align}
\int_{-\infin}^{0}f(t)dt=\int_{0}^{\infin}f(t)dt
\end{align}
$$
and we also know
$$
\begin{align}
\int_{-x}^{0}f(t)dt&=\int_{0}^{x}f(t)dt
\end{align}
$$
Thus we have the following property
$$
\begin{align}
\int_{-\infin}^{0}f(t)dt-\int_{-x}^{0}f(t)dt&=\int_{0}^{\infin}f(t)dt-\int_{0}^{x}f(t)dt\\
\int_{-\infin}^{x}f(t)dt&=\int_{-x}^{\infin}f(t)dt\\
F(x)-F(-\infin)&=F(\infin)-F(-x)\\
F(x)-0&=1-F(-x)\\
F(-x)&=1-F(x)
\end{align}
$$

### Solution 2

a) From geometry, we know that $P(X<r)=\frac{\text{the are of circle with radius r}}{\text{the area of the entire circle}}=\frac{\pi r^2}{\pi \cdot 1^2}=r^2$

​	Hence the cumulative distribution function
$$
F_X(x)=r^2
$$
b) Below is the answer
$$
P(r<X<s)=F_X(s)-F_X(r)=s^2-r^2
$$
c) The pdf of $X$ is therefore
$$
f_X(x)=\frac{d}{dx}F_X(x)=2r
$$
d) The mean can be calculated by the following integration between interval $[0,1]$
$$
E_X(X)=\int_{0}^{1}xf_X(x)dx=\int_{0}^{1}2r^2dr=\frac{2}{3}
$$

### Solution 3

The mean of an $\exp(\lambda)$ can be calculated as
$$
\begin{align}
E_X(X)&=\int_{0}^{\infin}x\cdot \lambda e^{-\lambda x}dx\\
&=F(\infin)-F(0) & \text{where $F(x)=-xe^{-\lambda x}-\frac{e^{-\lambda x}}{\lambda}$}\\
&=0-(-\frac{1}{\lambda})\\
&=\frac{1}{\lambda}
\end{align}
$$
Then the variance can be calculated as
$$
\begin{align}
Var_X(X)&=E(X^2)-(E(X))^2\\
&=\int_{0}^{\infin}x^2\cdot \lambda e^{-\lambda x}dx-(\frac{1}{\lambda})^2\\
&=F(\infin)-F(0)-\frac{1}{\lambda^2}\\
\end{align}
$$
where $F(x)=-x^2e^{-\lambda x}-\frac{2xe^{-\lambda x}}{\lambda}-\frac{2e^{-\lambda x}}{\lambda ^2}$

To find the value of $F(\infin)$, we have to use limit with L'Hopital rule
$$
\lim_{x\rightarrow\infin}-x^2e^{-\lambda x}=\lim_{x\rightarrow\infin}\frac{-x^2}{e^{\lambda x}}=\lim_{x\rightarrow\infin}\frac{-2x}{\lambda e^{\lambda x}}
=\lim_{x\rightarrow\infin}\frac{-2}{\lambda^2 e^{\lambda x}}=0
$$
Hence
$$
\begin{align}
Var_X(X)&=-F(0)-\frac{1}{\lambda^2}\\
&=\frac{2}{\lambda^2}-\frac{1}{\lambda^2}\\
&=\frac{1}{\lambda^2}
\end{align}
$$

### Solution 4

$$
m(t)=\int_{0}^{\infin}e^{tx}f(x)dx
$$

a) the mgf of function $xf(x)$ is
$$
m_{xf(x)}(t)=\int_{0}^{\infin}e^{tx}xf(x)dx
$$
​	Therefore, assuming differentiation inside the integral is valid
$$
m'(t)=\frac{d}{dt}(\int_{0}^{\infin}e^{tx}f(x)dx)=\int_{0}^{\infin}(\frac{d}{dt}e^{tx}f(x))dx=\int_{0}^{\infin}xe^{tx}f(x)dx=m_{xf(x)}(t)
$$
b) The $n$th derivative can be obtained as
$$
m^{(n)}(t)=\int_{0}^{\infin}x^ne^{tx}f(x)dx=\frac{k\int_{0}^{\infin}x^ne^{tx}f(x)dx}{k}=k\int_{0}^{\infin}\frac{x^ne^{tx}f(x)}{k}dx
$$
​	where $k$ could be the $m^{(n)}(0)$

c) $X$ being exponential indicates that
$$
f(x)=\lambda e^{-\lambda x}
$$
​	The mgt and its $n$th derivative of $X$ is
$$
\begin{align}
m(t)&=\int_{0}^{\infin}e^{tx}(\lambda e^{-\lambda x})dx\\
m^{(n)}(t)&=\int_{0}^{\infin}x^ne^{tx}(\lambda e^{-\lambda x})dx\\
m^{(n)}(0)&=\int_{0}^{\infin}x^n(\lambda e^{-\lambda x})dx\\
&=(-e^{-\lambda x}(\sum_{i=0}^{n}\frac{i!\cdot x^{n-i}}{\lambda ^i}))\Big|^\infin_0\\
\end{align}
$$
To determine the limitation when $x$ approaches to $\infin$, we again use L'Hopital's rule to generalize the limit to all the sumation terms in the equation above
$$
\lim_{x\rightarrow \infin}-e^{-\lambda x}(\frac{i!\cdot x^{n-i}}{\lambda^i})=\lim_{x\rightarrow \infin}-\frac{i!\cdot x^{n-i}}{\lambda^ie^{\lambda x}}=\lim_{x\rightarrow \infin}-\frac{n!}{\lambda^ne^{\lambda x}}=0
$$
Hence $m(t)$ becomes
$$
 m(t)=0-(-1\cdot \frac{n!}{\lambda ^n})=\frac{n!}{\lambda ^ n}
$$

### Solution 5

a) We can define $T_n$ directly by the definition of exponential random variable
$$
T_n=T_1+T_2+T_3+...=\sum_{i=1}^{n}\lambda e^{-\lambda x}
$$
​	Hence the moment generating function of pdf of $T_n$ is
$$
\begin{align}
M_{T_n}(t)&=(\int_{0}^{\infin}e^{tx}(\lambda e^{-\lambda x})dx)^n\\
&=(\int_{0}^{\infin}\lambda e^{(t-\lambda)x}dx)^n\\
&=((\frac{\lambda}{t-\lambda}e^{(t-\lambda)x})\Big|^{\infin}_{x=0})^n\\
&=(0-\frac{\lambda}{t-\lambda})^n\\
&=(\frac{\lambda}{\lambda-t})^n
\end{align}
$$
b) Using moment generating function, we can determine the probability density function as follow
$$
\begin{align}
(\frac{\lambda}{\lambda - t})^n&=\int_{0}^{\infin}e^{tx}f(x)dx\\

\frac{\lambda^{n-1}}{(n-1)!}\frac{d^{n-1}}{dt^{n-1}}(\frac{\lambda}{\lambda -t})&=\frac{d^{n-1}}{dt^{n-1}}(\int_{0}^{\infin}e^{tx}f(x)dx)\\

\frac{d^{n-1}}{dt^{n-1}}\frac{(n-1)!}{\lambda^{n-1}}(\frac{\lambda}{\lambda - t})&=\int_{0}^{\infin}(\frac{d^{n-1}}{dt^{n-1}}e^{tx}f(x))dx)\\

\frac{d^{n-1}}{dt^{n-1}}\frac{(n-1)!}{\lambda^{n-1}}(\frac{\lambda}{\lambda - t})&=
\int_{0}^{\infin}x^{n-1}e^{tx}f(x)dx\\

\end{align}
$$

### Solution 6

a) It is easy to show that
$$
\begin{align}
\int_{0}^{x}g_{n+1}(u)du&=\int_{0}^{x}\frac{\lambda^{n+1}u^n}{n!}e^{-\lambda u}du\\
&=-\frac{\lambda ^nu^ne^{-\lambda u}}{n!}+\int_0^x\frac{e^{-\lambda u}}{\lambda}\cdot \frac{\lambda^{n+1}u^{n-1}}{(n-1)!}du\\
&=-\frac{(\lambda u)^n}{n!}e^{-\lambda u}+\int_0^x\frac{e^{-\lambda u}\lambda^nu^{n-1}}{(n-1)!}dx\\
&=\int_0^xg_{n}(u)du-\frac{(\lambda u)^n}{n!}e^{-\lambda u}
\end{align}
$$
b) From 5b and 6a we know that
$$
\begin{align}
T_n\le x&\Rightarrow g_n(x)\le x&\\
&\Rightarrow \frac{\lambda^nx^{n-1}}{(n-1)!}e^{-\lambda x}\le x\\
&\Rightarrow \frac{\lambda^nx^{n}}{n!}e^{-\lambda x}\le \frac{x^2}{n}\\
&\Rightarrow \frac{\lambda^nx^{n}}{n!}e^{-\lambda x}\le \frac{x}{\lambda}\\
&\Rightarrow \frac{\lambda^nx^{n}}{n!}e^{-\lambda x}\ge \frac{\lambda}{x}=n\\
\end{align}
$$

$$
\begin{align}
P(N_x=n)&=\frac{e^{-\lambda x}(\lambda x)^n}{n!}\\
P(T_n\le x)-P(T_{n+1}\le x)&=\int_{0}^{x}g_n(x)dx-\int_{0}^{x}g_{n}(x)dx+\frac{(\lambda x)^n}{n!}e^{-\lambda x}=\frac{(\lambda x)^n}{n!}e^{-\lambda x}
\end{align}
$$

c) From b) we know that $P(N_x=n)$ follows Poisson distribution by substituting $\lambda x$ into the Poisson distribution equation

### Solution 7

The cdf of $X$ is
$$
F(x)=\left\{\begin{align}
0 & & x<0\\
x & & 0\le x < 1\\
1 & & x\ge 1
\end{align}
\right.
$$
The pdf of the transfofrmed variable $Y=e^X$ is
$$
p_Y(x)=\left\{\begin{align}
&0 & x<0\\
&\frac{e^x}{e-1} & 0\le x\le 1\\
&0 & x>1
\end{align}
\right.
$$

### Solution 8

$X-\mu$ will result in a left shift of the random variable, with itself still being a normal distribution. Divided by $\sigma$ will result in the graph being shrunk but still it will be a normal distribution. According to the linear transformation of mean and variance, the new mean will be $\mu-\mu=0$ and the new variance will be $\frac{\sigma^2}{\sigma^2}=1$

Hence, $Y\sim N(0,1)$

### Solution 9

a) Using the definition of pdf, we can easily find $F_Y(y)$
$$
F_Y(y)=F_X(\frac{y-b}{a})
$$
b) Using chain rule
$$
\begin{align}
f_Y(y)=F'_Y(y)&=F'_X(\frac{y-b}{a})\cdot \frac{1}{a}\\
&=\frac{1}{\lvert a\rvert}f_X(\frac{y-b}{a})
\end{align}
$$

### Solution 10

a) $z=1.16$

b) $z=1.09$

c) $z=-1.35$

### Solution 11

a) $area=0.38493$

b) $area=0.25175$

c) $area=0.66369$

d) $area=0.18278$

e) $area=0.89973$

### Solution 12

a) We first find the pmf of the Bernoulli random variable $\tilde{B}=p^x(1-p)^{1-x}$
$$
p_{\tilde{B}}(x)=\left\{\begin{align}
&p & x=\sqrt{\frac{1-p}{p}}\\
&1-p & x=-\sqrt{\frac{p}{1-p}}\\
&0 & 
\end{align}
\right.
$$
​	The mean can be calculated as follows
$$
\begin{align}
E(\tilde{B})&=p\sqrt{\frac{1-p}{p}}-(1-p)\sqrt{\frac{p}{1-p}}\\
&=\sqrt{p(1-p)}-\sqrt{(1-p)p}=0
\end{align}
$$
​	The variance can be calculated as follows
$$
\begin{align}
Var(\tilde{B})&=E(\tilde{B}^2)-(E(\tilde{B}))^2\\
&=\frac{1-p}{p}\cdot p+\frac{p}{1-p}\cdot(1-p)-0\\
&=1-p+p=1
\end{align}
$$
b) The characteristic function of $\tilde{B}$ is
$$
\begin{align}
\phi_X(t)=E(e^{itx})=\sum_{k=1}^{n}e^{itk}p_{\tilde{B}}(k)&=e^{it\sqrt{\frac{1-p}{np}}}p+e^{-it\sqrt{\frac{p}{n(1-p)}}}(1-p)\\
\end{align}
$$
​	and thus the characteristic function of $S=\frac{1}{\sqrt{n}}\sum_{i=1}^{n}{\tilde{B}}$ is 
$$
\phi_S(t)=\prod_{j=1}^{n}\phi_{X_{i}}(t)=(E(e^{itx}))^n=(e^{it\sqrt{\frac{1-p}{np}}}p+e^{-it\sqrt{\frac{p}{n(1-p)}}}(1-p))^n
$$
c) As $n\rightarrow \infin$, the number of samples become large enough to allow sample mean to converge to normal distribution according to Central Limit Theorem. $e^{-\frac{t^2}{2}}$ is the characteristic function of normal distribution, which conforms the previous statement.

### Solution 13

a) The probability generating function $G_{\text{Bin}}(z)$ is
$$
\begin{align}
G_{\text{Bin}}(z)=E_X(z^X)&=\sum_xp_X(x)z^x\\
&=\sum_x{n \choose x}(pz)^x(1-p)^{n-x}\\
&=(px+1-p)^n
\end{align}
$$
​	As $n\rightarrow \infin$, we have
$$
\begin{align}
\lim_{n\rightarrow \infin}G_{\text{Bin}}(z)&=\lim_{n\rightarrow \infin}(px+1-p)^n\\
&=\lim_{n\rightarrow \infin}(1+\frac{\lambda z-\lambda}{n})^n\\
&=e^{\lambda x - \lambda}\\
&=e^{-\lambda(1-z)}
\end{align}
$$
b) Similar as above, the pgf of a sequence of Binomial pmfs is the same as the pgf of Poisson distribution $e^{\lambda (z-1)}$, which indicates that as $n\rightarrow\infin$, the pmfs will tend to a Poisson pmf.

