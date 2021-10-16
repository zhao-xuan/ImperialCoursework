# Probability and Statistics Exercise 1 - Event

### Solution 1

From Axiom 3 we know that
$$
P(E)=P(E \cap F) + P(E \cap \bar{F})\\
P(F)=P(F \cap E)+P(F\cap \bar{E})\\
P(E\cup F)=P(E\cap F) + P(E\cap \bar{F}) + P(F \cap \bar{E})
$$
Therefore, we have
$$
\begin{align}
P(E\cup F)&=P(E\cap F)+P(E)-P(E\cap F)+P(F)-P(E\cap F)\\
&=P(E)+P(F)-P(E\cap F)
\end{align}
$$

### Solution 2

$E$ and $F$ will be independent if they satisfy the following property
$$
P(E \cap F)=P(E)P(F)
$$
Since $E$ and $F$ are mutually exclusive, it must be that
$$
P(E\cap F)=P(\emptyset)=0
$$
Therefore, either $P(E)=0$ or $P(F)=0$.

### Solution 3

a) $P(\text{odd number})=\frac{1}{2}$

b) $P(\text{odd number less than 4})=\frac{1}{3}$

### Solution 4

a) $P(\text{two sixes})=\frac{1}{6} \cdot \frac{1}{6}=\frac{1}{36}$.

b) $P(\text{total of 3})=\frac{2}{36}=\frac{1}{18}$

### Solution 5

$P(\text{problem solved})=1-P(\text{A failed}\cap \text{B failed})=1-P(\text{A failed})P(\text{B failed})=1-(1-\frac{2}{5})(1-\frac{1}{3})=\frac{3}{5}$

### Solution 6

$P(\text{AX.XB<}\frac{3}{16})=P(x(1-x)<\frac{3}{16})=\frac{1}{2}$

### Solution 7

a) $P(\text{odd outcome})=\frac{18}{37}$

b) i. $P(\text{first is red})=\frac{x}{x+y}$

​    ii. $P(\text{second is red})=\frac{x(x+y-1)}{(x+y)(x+y-1)}=\frac{x}{x+y}$

​    iii. $P(\text{first two are red})=\frac{x}{x+y}\cdot \frac{x}{x+y-1}=\frac{x^2}{(x+y)(x+y-1)}$

​    iv. $P(\text{last but one is red})=\frac{x}{x+y}$

### Solution 8

a) $P(\text{coin head}\cap \text{odd number})=\frac{1}{2}\cdot \frac{3}{6}=\frac{1}{4}$

b) Since there are $30\%$ females in the class, there are $70\%$ males in the class. The final ratio of the class that passed exam is $P(\text{passed})=0.9\cdot 0.7+0.8\cdot 0.3=0.87$, which is $87\%$.

### Solution 9

a) The events of rain on two consecutive days are NOT independent since $P(\text{first day rain})P(\text{second day rain})=\frac{1}{4}\cdot \frac{1}{4}=\frac{1}{16}\neq \frac{1}{10}$.

b) Let $E=\text{chance of rain today}$ and $F=\text{chance of rain tomorrow}$, then
$$
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{\frac{1}{10}}{\frac{1}{4}}=\frac{2}{5}
$$
c) Let $E=\text{chance of rain today}$ and $F=\text{chance of rain tomorrow}$, then
$$
P(E|F)=\frac{P(E\cap F)}{P(F)}=\frac{\frac{1}{10}}{\frac{1}{4}}=\frac{2}{5}
$$

### Solution 10

a) $P(\text{leave it in the fourth shop})=(1-\frac{1}{4})^3\cdot \frac{1}{4}=\frac{27}{256}$

b) Let $E=\text{he left his umbrella}$ and $F=\text{he left it in the fourth shop}$, then
$$
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{\frac{27}{256}}{\frac{1}{4}+\frac{3}{4}\cdot\frac{1}{4}+\frac{3}{4}\cdot\frac{3}{4}\cdot\frac{1}{4}+\frac{3}{4}\cdot\frac{3}{4}\cdot\frac{3}{4}\cdot \frac{1}{4}}=\frac{\frac{27}{256}}{\frac{175}{256}}=\frac{27}{175}
$$
c) Let $E=\text{he left his umbrella after the first shop}$ and $F=\text{he left it in the fourth shop}$, then
$$
P(E)=\frac{175}{256}-\frac{1}{4}=\frac{111}{256}\\
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{\frac{27}{256}}{\frac{111}{256}}=\frac{9}{37}
$$

### Solution 11

a) $P(\text{component is satisfactory})=0.4\cdot 0.8+0.4\cdot 0.9+0.2=0.88$

b) $P(\text{exactly one out of two is satisfactory})=0.4\cdot 0.8\cdot 0.2\cdot 2+0.4\cdot 0.9\cdot 0.1\cdot 2=0.2$

c) Let $E=\text{pack with one out of two components tested as satisfactory}$ and $F=\text{selected pack contained medium quality components}$, then
$$
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{0.4\cdot 0.9\cdot 0.1\cdot 2}{0.2}=0.36
$$
d) Let $E=\text{pack with both components tested as satisfactory}$ and $F=\text{pack contained high quality components}$, then
$$
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{0.2}{0.78}=\frac{10}{39}
$$

### Solution 12

From the Bayes Theorem we know that
$$
P(A|B)=\frac{P(A)P(B|A)}{P(B)} \Rightarrow \frac{P(A|B)}{P(B|A)}=\frac{P(A)}{P(B)}
$$
Since $P(A)\ge P(B)>0$, we know that $\frac{P(A)}{P(B)}\ge 1$ and hence $\frac{P(A|B)}{P(B|A)}\ge 1$, which means that $P(A|B)\ge P(B|A)$.

### Solution 13

Since $A, B, $ and $C$ are independent, it is the case that
$$
P(A\cap B\cap C)=P(A)P(B)P(C)\\
P(A\cap B)=P(A)P(B)\\
P(A\cap C)=P(A)P(C)\\
P(B\cap C)=P(B)P(C)
$$
Then we have
$$
\begin{align}
P(A\cap (B\cup C))&=P((A\cap B)\cup (A\cap C)) & \text{set operation}\\
&=P(A\cap B)+P(A\cap C)-P((A\cap B)\cap (A\cap C)) & \text{From Q1}\\
&=P(A\cap B)+P(A\cap C)-P(A\cap B\cap C)\\
&=P(A)P(B)+P(A)P(C)-P(A)P(B)P(C)\\
&=P(A)(P(B)+P(C)-P(B)P(C))\\
&=P(A)(P(B)+P(C)-P(B\cap C))\\
&=P(A)P(B\cup C) & \text{From the reverse of Q1}
\end{align}
$$
Therefore, we have proved that $A$ and $B\cup C$ are independent.

### Solution 14

a) $P(A)=P(\text{{a}})+P(\text{{b}})=0.2+0.3=0.5$

b) $P(B)=P(\text{{b}})+P(\text{{c}})+P(\text{{d}})=0.3+0.4+0.1=0.8$

c) $P(\bar{A})=1-P(A)=0.5$

d) $P(A\cup B)=P(S)=1$

e) $P(A\cap B)=P(\text{{b}})=0.3$

### Solution 15

Let $E=\text{random part to be defective}$ and $F=\text{random part came from factory 1}$, then
$$
P(F|E)=\frac{P(E\cap F)}{P(E)}=\frac{\frac{1}{30}}{\frac{1}{12}}=\frac{2}{5}
$$

### Solution 16

We first want to show the following properties
$$
P(A\cap B)=P(A)P(B)\\
P(A\cap C)=P(A)P(C)\\
P(B\cap C)=P(B)P(C)
$$
We know that $P(A)=\frac{1}{2}$ and $P(B)=\frac{1}{2}$ and that $P(A\cap B)=\frac{1}{4}$, thus proved the first property.

We know that $P(A)=\frac{1}{2}$ and $P(C)=\frac{1}{2}$ and that $P(A\cap C)=\frac{1}{4}$, thus proved the second property.

The rest follows from the facts.

We then show that $P(A\cap B\cap C)\ne P(A)P(B)P(C)$.

We know that $P(A\cap B\cap C)=0$ since when both die are odd, the sum must be even. We also know that $P(A)P(B)P(C)=\frac{1}{8}\ne 0$.

### Solution 17

a) $P(\text{random phone being defective})=0.5\cdot 0.02+0.3\cdot 0.05+0.2\cdot 0.01=0.027$

b) $P(\text{defective from the second plant})=\frac{0.3\cdot 0.05}{0.027}=\frac{5}{9}$

### Solution 18

$P(\text{win})=\frac{8}{36}+\frac{24}{36}\cdot (P(\text{point before 7}))$