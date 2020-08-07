# 145 Mathematical Method Coursework

## Couserwork 1 - Limits and Sequences

### 1

1. Supremum: 5, Infimum: 1. Both infimum and maximum are in the set.
2. Supremum: $\sqrt{ 29}$, Infimum: $-\sqrt{29}$. Infimum is in the set; supremum does not exist because the upper bound $s>29$. There are infinitely many rational numbers when approaching 29 from the positive side on the number axis, so there is no minimum upper bound for this set.
3. Supremum: $\sqrt{29}$, Infimum: $-\sqrt{ 29}$. Both supremum and infimum are in the set.

### 2

1. Gussed limit: 0. Proof is as follows:

   - By definition of sequence convergence, we need to show that for the limit $l=0$, there exists a natural number $N$ and for all positive real number $\epsilon:\R^+$, such that $\forall n>N, |a_n-l|<\epsilon$
   - Plug in the equation for $a_n$ and limit $l=0$ we have:

   $$
   |-\frac{1}{\sqrt{2n}}-0|<\epsilon\\
   \frac{1}{\sqrt{2n}}<\epsilon\\
   \frac{1}{\epsilon}<\sqrt{2n}\\
   \frac{1}{2\epsilon^2}<n
   $$

   - If we set $N=\lceil \frac{1}{2\epsilon^2} \rceil$, we can satisfy that $\forall n>N, |a_n-l|<\epsilon$ for some positive value of $\epsilon $. Hence, by definition of convergence, we have proved that the sequence tend to the limit $0$

2. Gussed limit: $\frac{1}{2}$. Proof is as follows:

   - By definition of sequence convergence, we need to show that for the limit $l=\frac{1}{2}$, there exists a natural number $N$ and for all positive real number $\epsilon:\R^+$ such that $\forall n>N, |a_n-l|<\epsilon$
   - Plug in the value of $a_n$ and limit we have:

   $$
   |\frac{1-e^{-n}}{2}-\frac{1}{2}|<\epsilon\\
   |-\frac{e^{-n}}{2}|<\epsilon\\
   \frac{e^{-n}}{2}<\epsilon\\
   \frac{1}{2\epsilon}<e^n\\
   \mathrm{ln\frac{1}{2\epsilon}}<n
   $$

   - If we set $N=\lceil ln\frac{1}{2\epsilon} \rceil$, we can satisfy that $\forall n>N, |a_n-l|<\epsilon$. Hence, by the definition of convergence, we have proved that the sequence tends to the limit $\frac{1}{2} $

3. Gussed limit: 1. Proof is as follows:

   - By definition of sequence convergence, we need to show that for the limit $l=1$ there exists a natural number $N$ and for all positive real number $\epsilon$ such that $\forall n>N, |a_n-l|<\epsilon$
   - Plug in the equation of $a_n$ and value of limit we have:

   $$
   |\frac{n-1}{n}-1|<\epsilon\\
   |\frac{n-1}{n}-\frac{n}{n}|<\epsilon\\
   |-\frac{1}{n}|<\epsilon\\
   \frac{1}{n}<\epsilon\\
   \frac{1}{\epsilon}<n
   $$

   - If we set $N=\lceil \frac{1}{\epsilon} \rceil$, we can satisfy that $\forall n>N, |a_n-1|<\epsilon$ for some value of $\epsilon$. Hence, by the definition of sequence convergence, we have proved that the sequence converges to the limit $1$

4. Gussed limit: $C$. Proof is as follows:

   - By definition of sequence convergence, we need to show that for a limit of $C$, there exists a natural number $N$ and for all positive real number $\epsilon$ such that $\forall n>N, |a_n-l|<\epsilon$
   - Plug in the value of $a_n$ and the limit we have:

   $$
   |C-C|<\epsilon\\
   0<\epsilon
   $$

   - Since $\epsilon$ is already defined as a positive real number, we can choose any $N$ we want to satisfy this condition. Hence, we have proved that this sequence tends to the limit $C$

### 3

We know that:
$$
n<n^2\\
\frac{1}{n}>\frac{1}{n^2}\\
-\frac{1}{n}<-\frac{1}{n^2}\\
1-\frac{1}{n}<1-\frac{1}{n^2}\\
$$
and:
$$
1-\frac{1}{n^2}<1
$$
Combined, we have:
$$
1-\frac{1}{n}<1-\frac{1}{n^2}<1
$$
Since we have shown in $2(c)$ that $\frac{n-1}{n}=1-\frac{1}{n}$ converges to 1, and in $2(d)$ that any sequence of a real constant would tends to that constant itself, and by sandwich theorem, $1-\frac{1}{n^2}$ tends to 1 as well.

### 4

1. Use sandwich theorem:
   - Let $u_n=0$, $v_n=\frac{1}{n^2}$. We know that $\lim_{x\rightarrow \infin}u_n=0$ and $\lim_{x\rightarrow \infin}v_n=0$
   - It's obvious that $u_n\le a_n\le v_n$ for all $n:\N$. Hence, $\lim_{x\rightarrow \infin}a_n=0$ as well
2. Use sandwich theorem:
   - Let $u_n=-\frac{1}{n}$, $v_n=\frac{1}{n}$. We know that $\lim_{x\rightarrow \infin}u_n=0$ and $\lim_{x\rightarrow \infin}v_n=0$
   - It's obvious that $u_n\le a_n\le v_n$ for all $n:\N$. Hence, $\lim_{x\rightarrow \infin}=0$

### 5

We now attempt a proof for $\lim_{n\rightarrow \infin}a_n=\frac{1}{8}$.

By definition of sequence convergence, we need to show that for the limit $l=\frac{1}{8}$, there exists a natural number $N$ and for all positive real number $\epsilon$ such that $\forall n>N, |a_n-l|<\epsilon$

Plug in the value of $a_n$ and $l$, we have:
$$
|2^{-n}-\frac{1}{8}|<\epsilon
$$
When $n\le 3$,
$$
2^{-n}-\frac{1}{8}<\epsilon\\
\frac{1}{2^n}<\epsilon+2^{-3}\\
\frac{1}{\epsilon+2^{-3}}<2^n\\
\log_{2}(\frac{1}{\epsilon+2^{-3}})<n
$$
When $n>3$,
$$
\frac{1}{8}-2^{-n}<\epsilon\\
\frac{1}{8}-\epsilon<\frac{1}{2^n}\\
2^n<\frac{1}{2^{-3}-\epsilon}\\
n<\log_{2}(\frac{1}{2^{-3}-\epsilon})
$$
Thus we can conclude that $n\in (\log_{2}(\frac{1}{2^{-3}+\epsilon}), \log_{2}{\frac{1}{2^{-3}-\epsilon}})$

Since $n$ is bounded above as shown, we cannot find any $N$ to satisfy that $\forall n>N, |a_n-\frac{1}{8}|<\epsilon$

### 6

1. By the definition of sequence convergence, we need to show that for the limit $l=0$, there exists a natural number $N$ and for all positive real number $\epsilon$ that $\forall n>N, |a_n-l|<\epsilon$

   Plug in the value of $a_n$ and limit we have:
   $$
   |n^{-\alpha}-0|<\epsilon\\
   n^{-\alpha}<\epsilon\\
   \frac{1}{\epsilon}<n^\alpha\\
   \epsilon^{-\frac{1}{\alpha}}<n
   $$
   We can set $N=\lceil \epsilon^{-\frac{1}{\alpha}} \rceil$, which will satify the definition of sequence onvergence. Hence, $a_n$ converges to $0$ as $n$ tends to infinity

2. We choose $u_n=0$ and $v_n=\frac{1}{n}$. Let $a_n=\frac{n!}{n^n}$. Clearly, $0<a_n$. Expand $a_n$ so that we will get:
   $$
   a_n=\frac{n!}{n^n}=\frac{n(n-1)(n-2)(n-3)...1}{n*n*n*...*n}\\=1\cdot (1-\frac{1}{n})(1-\frac{2}{n})(1-\frac{3}{n})...(1-\frac{n-1}{n})\\
   =1\cdot (1-\frac{1}{n})(1-\frac{2}{n})(1-\frac{3}{n})...\frac{1}{n}<\frac{1}{n}
   $$
   Since both $u_n$ and $v_n$ converge to $0$, we have $a_n$ converges to $0$ as well according to the sandwich theorem.

3. It will tend to $0$ as $n\rightarrow \infin$

   We use sandwich theorem to approach to this question

   From $(b)$, we've known that $\lim_{n\rightarrow \infin}\frac{n!}{n^n}=0$. It's obvious that $0<\frac{n!}{n^p}$.

   When $p<n$, we have:
   $$
   
   $$
   

   

   