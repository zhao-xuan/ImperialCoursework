# 150 Graph and Algorithm Exams

## 2019 Exam

### 1a

1. A sapnning tree of a graph $G$ is a connected acyclic graph, or a tree $T$, that has the following property: $T$ is a subgraph of $G$ and $nodes(T)=nodes(G)$

2. BFS traversal order: 1 2 7 3 8 5 6 4

   1 --> 2, 7	2 --> 8, 3	3 --> 4	7 --> 6, 5

### 1b

Take $G$ as a connected graph with finite number of nodes and no cycles. 

Assume $G$ has no sink node. It means that every node in $G$ will have at least one outgoing arc. We can create a cycle by repeatedly selecting nodes in $G$ until we meet a repetition. We can do this beacuse every node in $G$ can point to some other nodes. But this contradicts the fact that $G$ has no cycles. So $G$ must at least have one sink node.

Assume $G$ has no source node. This means that every node in $G$ is pointed by another node. We can again create a cycle by selecting the node that points at the current node until a repetition. Thus, $G$ has at least one source node.

### 1c

Count will become $2n+6m$, or $O(n+m)$

### 1d

1. An MST is a spanning tree of $G$ whose sum of weight of all arcs is the lowest among other spanning trees of $G$

2. Pick a node as the start node. Mark start node as in tree. Mark the adjacent nodes of start node as fringe.

   $^{(*)}$ Pick the arc from one fringe node to one tree node such that the weight of the arc is the maximum among all the possible arcs at this stage. Let this arc be $A$ and let the tree node it connects to be $x$ and fringe node as $y$. Classify $y$ as a tree node and all unseen nodes of $y$ as fringe nodes.

   Repeat $^{(*)}$ until all nodes are visited. This will create a maximum spanning tree.

   This will create a maximum spanning tree. Assume that the standard algorithm for finding the minimum tree is correct. Since the proccedure above will always make sure that the arc with maximum weight is added to the tree, at every iteration of $^{(*)}$ the tree will guarantee to be part of the maximum spanning tree. Thus it will eventually create a maximum spanning tree.

### 2a

1. 5 comparisons

2. There should be $n-1$ comparisons.

   Since $L$ is pair-swapped, insertion sort will compare each pair and make a swap. there are $\frac{n}{2}$ pairs in total so $\frac{n}{2}$ comparisons. Between every pair there is one comparison just to confirm that the first number of the larger pair does not need to be inserted into the lower pair. There are $\frac{n}{2} - 1$ comparisons here and $\frac{n}{2} + \frac{n}{2}-1=n-1$ conmparisons in total.

### 2b

1. 3 --> 5, 16	5 --> 7, 2	7 --> 13	16 --> 10, 9

2. 16 --> 7, 13  7 --> 5, 2    5 --> 3      13 --> 10, 9

   Array: [16, 13, 10, 7, 2, 3, 9, 5]

### 2c

1. It means that graph $G$ has a path that visited every node of $G$ exactly once.

2. We can define a problem $\mathrm{Veri-HPN(G, x, y, \pi)}$ and define $\pi$ to be a list of nodes that connected $x$ and $y$ using all other nodes, such that: $\mathrm{HPN(G, x, y)}$ iff $\mathrm{\exist z, Veri-HPN(G, x, y, z)}$.

   Clearly, $Veri-HPN(G, x, y, \pi) \in P$ since it's easy to check whether each path in $\pi$ is a Hamiltonian path from $x$ to $y$.

   Since $|\pi|\le |nodes(G)|-1$, thereby $HPN \in NP$

3. To show that $HPN \in NPC$, we need to show that
   $$
   \mathrm{HPN} \in \mathrm{NP}\\
   \mathrm{\exist D \in NPC, \space D \le HPN}
   $$
   We have already shown $\mathrm{HPN \in NP}$ in 2, and we assume that we know $\mathrm{HamPath\in NPC}$.

   We need to show that $\mathrm{HamPath \le HPN}$

   We define a function $f$ that maps a graph $G$ to itself. (e.g. $f$ is an identity function)

   Clearly, $f$ is p-time bounded without any operations.

   Now we have $\mathrm{HamPath(G) \space iff \space \exist x,y \space HPN(f(G), x, y)}$

   Therefore, $\mathrm{HPN \in NPC}$

## 2018 Exam

### 1a

There are 8 automorphism of graph $G$.

Node 3 has two possible locations, either 3 or 5. Fix 3, then node 5 is fixed as well, and we now inspect node 2. Node 2 has 4 possible places to go, either 2, 4, 6, or 8. Fix 2, then the rest of the node are fixed as well. There are $2 * 4=8$ different automorphisms in total.

### 1b

1. It means that $T$ is a connected acyclic graph that has the following property:

   * $nodes(T)=nodes(G)$
   * $T$ is a subgraph of $G$

   Alternative definition: $T$ has all nodes in $G$ and connected those nodes using minimal number of arcs in $G$.

2. We can build a spanning tree of any graph $G$ by removing all the cycles in $G$. Since $a$ is in $G$ but is not in $T$, it means that $a$ is in at least one of the cycles in $G$. Therefore, when we restore arc $a$, there must be at least one cycle formed. If not, $a$ should not be removed in the first place during the process of tree building.

   Assume that after adding $a$ to $T$, $T'$ has two or more cycles. If we remove $a$, there must at least be one cycle left since removing one arc is only capable of removing one cycle. However, this contradicts the fact that $T$ is a spanning tree that has no cycles. Thus, adding $a$ to $T$ will form a unique cycle.

### 1c

1. ```mermaid
   graph LR
   A((A)) --- |7| H((H))
   B((B)) --- |8| C((C))
   F((F)) --- |1| E((E))
   B --- |2| D((D))
   D --- |3| E
   H --- |4| G((G))
   H --- |5| F
   ```

   Order of adding: $FE, BD, DE, HG, HF, AH, BC$

2. It indeed has a unique MST as shown above. Let's label the MST as $T$. Any other MST has to use arcs that are not in $T$. Those arcs have weight 8, 9, 10, 10. The only possible arc is $GF$ which has weight 8, as this would not add more weight compared to $T$. However, node $G$ and $F$ have already been joined by arcs that have less weight than 8. Thus, the graph has a unique MST.

### 1d

$T$ is also an MST for $(G, W')$. We know that Kruskal's algorithm will generate an MST for any connected graph, so we will illustrate our statement through this algorithm. For graph $(G,W)$, it will have arcs of weight from lowest to highest as $[w_1, w_2, w_3, ...,w_n]$. For graph $(G, W')$, it will have arcs of weight from lowest to highest as $[w_1^2, w_2^2, w_3^2,...,w_n^2]$. Kruskal's algorithm will choose the arc with lowest weight from $(G,W')$ first. Since $\forall n:\N, n \le n^2$, we have $w_1^2 \le w_2^2$ from the fact that $w_1 \le w_2$. This means that the lowest arc in $(G,W')$ is still the lowest arc in $(G,W)$. The same reason will apply for the rest of the arcs. This means that Kruskal algorithm will choose arcs in the same order in both $(G,W)$ and $(G,W')$. Thus, the MST generated form $(G, W)$ will also be the MST for $(G, W')$

### 2a

1. ```mermaid
   graph TB
   A((2)) --- B((0))
   B --- F1[Fail]
   B --- C((1))
   C --- F2[Fail]
   C --- F3[Fail]
   A --- D((3))
   D --- F4[Fail]
   D --- E((4))
   E --- F5[Fail]
   E --- F6[Fail]
   ```

   Worst case will have 3 comparisons

2. Average number of comparison: $\frac{1}{5}(1+2+2+3+3)=\frac{11}{5}$.

### 2b

1. $\mathrm{W(n)=n-1+W(\lfloor\frac{n}{2}\rfloor)+W(\lceil\frac{n}{2}\rceil)}$
2. $\mathrm{W(n)=\frac{n}{2}+W(\lfloor\frac{n}{2}\rfloor)+W(\lceil\frac{n}{2}\rceil)}$, assume $n$ is a power of two.

### 2c

1. $D \le D'$ means that there is a p-time bounded function $f$ such that
   $$
   D(x) \space \mathrm{iff} D'(f(x))
   $$

2. A graph $G$ is $k$-colorable iff every node can be colored in no more than $k$ colors such that its adjacent node does not have the same color as itself.

3. We now show that $\mathrm{3COL \in NP}$. We define a problem $\mathrm{Veri 3COL(G,\pi)}$ where list $\pi$ is a list of nodes each associated with one of the three colors(could be represented as $0,1,2$), such that $\mathrm{3COL(G)\:iff\:\exist\pi\:Veri3COL(G,\pi)}$.

   Clearly, $|\pi| \le |nodes(G)|$ and $\mathrm{Veri3Col(G,\pi)}$ is bounded by p-time since this problem checks all the adjacent nodes of each node, which is at most $n(n-1)$.

   Therefore, it's clear that $\mathrm{3COL \in NP}$

4. To show that $\mathrm{4COL\in NPC}$, we need to show that:
   $$
   \mathrm{4COL \in NP}\\
   \mathrm{\exist D \in NPC,\:D \le 4COL}
   $$
   We have already shown in $(3)$ that $\mathrm{3COL \in NP}$, so we can use similar reasoning to show that $\mathrm{4COL \in NP}$ as well. We can construct a problem $\mathrm{Veri4COL(G, \pi)}$ where $\pi$ is a list of all nodes in $G$ each associated with one of the four colors(could be represented as $0, 1, 2, 3$). For the same reason as in $(3)$, $\mathrm{Veri4COL(G,\pi)}$ is p-bounded and $\mathrm{4COL\in NP}$

   Now we need to show the second statement. We have assumed that $\mathrm{3COL\in NPC}$, so we can just show $\mathrm{3COL \le 4COL}$.

   We can define a p-time function $f$ such that it transforms the graph $G$ into a new graph $G' $ in the following way:

   * add a new node $N$ to $G$ and make a connection from all other nodes in $G$ to $N$. The new graph is $G'$. Clearly this is p-time bounded since there are at most $n$ nodes in $G$.
   * If the original graph $G$ is 3-colorable, then $G'$ would be 4-colorable since we only need to add an additional color for the new node, and vice versa.

   Then we have $\mathrm{3COL(G)\: iff\: 4COL(f(G))}$

   Thus, $\mathrm{4COL \in NPC}$

## 2017

**Note: there is no 150 Graph and Algorithm back in 2017, and the most relevant content is in class 202 Software engineering - Algorithms. This solution only contains questions related to the course content of 150 Graph and Algorithm taught in 2019-2020*

*The relevant questions that I see fit to the course materials are **1a, 1b, 1c, 1d, 2b, 2ci)***

### 1a

1. Base case: when $n=1$, $F_0=0, F_1=1, F_2=1$, according to the matrix. This is the correct Fibonacci numbers as we know. $(F_2=F_1+F_0)$

   Inductive case: assume we know that the recursive squaring of the matrix $n$ times will give the correct Fibonacci numbers $F_{n+1},F_n, F_{n-1}$ for some $n$, we need to show that squaring $n+1$ times gives the correct numbers for $F_{n+2},F_{n+1},F_n$ for $n+1$

   As the definition of the matrix:
   $$
   \begin{bmatrix}
   F_{n+2} & F_{n+1}\\
   F_{n+1} & F_{n}
   \end{bmatrix}
   =
   \begin{bmatrix}
   1 & 1\\
   1 & 0
   \end{bmatrix}^{n+1}
   =
   \begin{bmatrix}
   1 & 1\\
   1 & 0
   \end{bmatrix}^n
   \begin{bmatrix}
   1 & 1\\
   1 & 0
   \end{bmatrix}
   $$
   using our inductive assumption we have:
   $$
   \begin{bmatrix}
   F_{n+2} & F_{n+1}\\
   F_{n+1} & F_{n}
   \end{bmatrix}
   =
   \begin{bmatrix}
   F_{n+1} & F_{n}\\
   F_{n} & F_{n-1}
   \end{bmatrix}
   \begin{bmatrix}
   1 & 1\\
   1 & 0
   \end{bmatrix}
   =
   \begin{bmatrix}
   F_{n+1} + F_n & F_{n+1}\\
   F_n + F_{n-1} & F_n
   \end{bmatrix}
   $$
   Using the definition of Fibonacci numbers, we can see that
   $$
   F_{n+2} = F_{n+1}+F_n\\
   F_{n+1} = F_n + F_{n-1}
   $$
   which means that the inductive case holds and for $n+1$, this theorem holds
   
2. $f(x,1)=x$

   $f(x,n)=(f(x,\lfloor\frac{n}{2}\rfloor))^2$ if n is even

   $f(x,n)=(f(x,\lfloor\frac{n}{2}\rfloor))^2\cdot x$ if n is odd

### 1b

1. Guessed upper bound: $O(n\:log\: n)$

   Using substitution:
   $$
   T(n)=2T(\frac{n}{2}+17)+n=2(2T(\frac{\frac{n}{2}+17}{2}+17)+\frac{n}{2}+17)+n\\
   =4T(\frac{n}{4}+\frac{17}{2}+17)+2n+17\\
   $$
   Let $n=2^k$, we can see that:
   $$
   4T(\frac{n}{4}+\frac{17}{2}+17)+2n+17\approx nT(\sum_{i=0}^{k}{\frac{17}{2^i}})+kn
   $$
   Assume that $T(n)$ terminates at this point. Since $k=log\:n$, the summation approximately takes $log\:n$ additions, and there are $n$ times $T(\sum_{i=0}^{k}{\frac{17}{2^i}})$ to compute. Together, there are roughly $n\:log\:n+n\approx n\:log\:n$ computations.

   Note that we ignored the constant factor and that $T(34)=-17$, which will guarantee that the recurrence will stop.

2. Gussed upper bound: $O(4^n)$

   If we define a base case $T(1)=1$ or $T(0)=1$, we will have
   $$
   T(n)=4T(n-2)+1=16T(n-4)+5=64T(n-6)+21\\
   \approx 4^n\cdot T(0\:or\:1)
   $$
   Hence, there will be $4^n$ computations involved.

### 1c

1. $E=\frac{log\:2}{log\:2}=1$, $f(n)=1$. We can see that $f(n)=O(n^{E-1})$ and thus the run time complexity is $\Theta(n)$
2. $E=\frac{log\:1}{log\: \frac{4}{5}}=0$, $f(n)=1$. We can see that $f(n)=\Theta(n^E)$ and thus the run time complextiy is $\Theta(log\:n)$
3. $E=\frac{log\:4}{log\:16}=\frac{1}{2}$, $f(n)=\sqrt{n}$. We can see that $f(n)=\Theta(n^E)$ and thus the run time complexity is $\Theta(\sqrt{n}\:log\:n)$
4. $E=\frac{log\:4}{log\:2}=2$, $f(n)=n^3+n^2$. We can see that $n^{E+1}=O(f(n))$ and thus the run time complexity is $\Theta(n^3)$

### 1d

1. There are $a^{1+log_bn}$ leaf nodes in a recursion tree. There are $a^l$ nodes in total at level $l$. The recurrence will stop when $b^l=n$, or $l=1+log_bn$. Thus the number of leaf at the last level will be $a^{1+log_bn}$
2. At each node of the decision tree, the will be $b-1$ divisions happen from top to bottom and $b-1$ combinations from bottom to top. There are $1+log_bn$ levels in total, so there will be in total $\sum_{i=0}^{1+log_bn}{b^i(2(b-1))}$ operations of divides and combines.

### 2b

1. Assume that we are at one of the cells in table $A$ and assume we know that at this point, we have reached the maximum of apples. We must have reached to this cell either from the cell above or from the cell to the left.

   We create another matrix $A'$ that calculate the accumulative numbers of apples for each cell in table $A$. Starting from the right bottom corner, we label the number in this cell as $F$, and the accumulative number in the cell above it as $T'$, and the accumulative number in the cell to the left as $L'$. we know that the accumulative numer $F'$ must be $max(F+T', F+L')$. We can calculate $T'$ and $L'$ in similary ways until we reach the starting point(the top left corner). The result will be stored at the right bottom corner of table $A'$ and we can track the path during this process by setting an array $\mathrm{parent[n]}$.

2. The complexity of $\mathrm{max\_apples(A)}$ will be $O(m+n)$

### 2ci

1. ```mermaid
   graph TB
   A --- Empty1[Nothing]
   A((A)) --- Y((Y))
   Y --- G((G))
   Y --- Empty2[Nothing]
   G --- F((F))
   G --- X((X))
   ```

## 2016

**Note: there is no 150 Graph and Algorithm back in 2016, and the most relevant content is in class 202 Software engineering - Algorithms. This solution only contains questions related to the course content of 150 Graph and Algorithm taught in 2019-2020*

*The relevant questions that I see fit to the course materials are **1a i) iii)***

### 1a

1. Constant grows slower than logarithm, and logarithm grows slower than polynomial; polynomial grows slower than exponential, and exponential grows slower than factorial.

   $\Theta(c)<\Theta(log\:n)<\Theta(n)<\Theta(c^n)<\Theta(n!)$

3. Guessed upper bound for A): $O(log\:n)$

   We can see that:
   $$
   T(n)=T(\frac{n}{2})+n^2=T(\frac{n}{4})+\frac{n^2}{4}+n^2=...
   $$
   Let $n=2^k$, we can see that:
   $$
   T(n)=\sum_{i=0}^{k}{\frac{n^2}{4^i}}
   $$
   There are $k$ summations in total, and since $k=log\:n$, the complexity is $O(log\:n)$

   Guessed upper bound B): $O(2^n)$

   We can see that:
   $$
   T(n)=2(2T(n-2)+1)+1=4T(n-2)+3=8T(n-3)+7\\
   \approx2^nT(1)
   $$
   Here, we ignored the constant factor and conclude that the complextiy is $O(2^n)$

## 2015

**Note: there is no 150 Graph and Algorithm back in 2015, and the most relevant content is in class 202 Software engineering - Algorithms. This solution only contains questions related to the course of 150 Graph and Algorithm content taught in 2019-2020*

*The relevant questions that I see fit to the course materials are **1a, 1d***

### 1a

1. Divide-andconquer strategy involves breaking bigger problem into smaller components so that the original problem is easier to solve.

   Three steps of divide and conquer:

   * Divide the problem into a number of subproblems that are smaller instances of the same problem.
   * Conquer the subproblems by solving them recursively. If they are small enough, solve the subporblems as base cases. (e.g. when length is 1)
   * Combine the solutions to the subproblems into the solution for the original problem. (e.g. summation)

2. When the subproblems overlap each other, we know it is the time to use dynamic programming; otherwise, when the subproblems are independent, we can just use divide-and-conquer. Dynamic programming is preferred when overlapping between subproblems happens because DP will only solve each subproblem once and store the result of each subproblem. When calculating the next subproblem, DP will execute depending on the previosuly stored values. In this way, DP can save more time(though use more space for memoisation) and take care of the dependency between subproblems.

3. Memoization is a technique used in DP that stores previously computed solutions of previous subproblems that might be used in future subproblems. It can help DP to make decisions faster since there is no need to re-compute previous subproblems.

### 1d

We use Master's Theorem for calculating the complexity

1. $E=\frac{log\:4}{log\:2}=2$, $f(n)=n^2$. We can see that $f(n)=\Theta(n^E)$. Thus, $O_A(n^2\:log\:n)$

2. $E=\frac{log\:8}{log\:2}=3$, $f(n)=n$. We can see that $f(n)=O(n^{E-2})$. Thus, $O_B(n^3)$

3. $E=\frac{log\:9}{log\:3}=2$, $f(n)=n$. We can see that $f(n)=O(n^{E-1})$. Thus, $O_C(n^2)$

4. Using substitution, we can see that:
   $$
   T(n)=T(n-1)+1=T(n-2)+1+1=T(n-3)+1+1+1=...\\
   =n
   $$
   Clearly, $O_D(n)$

We then put them in increasing order of complexity:

$O_D(n)<O_C(n^2)<O_A(n^2\:log\:n)<O_B(n^3)$

## 2014

**Note: there is no 150 Graph and Algorithm back in 2014, and the most relevant content is in class MC202 Software engineering - Algorithms. Note that this course is under JMC section. This solution only contains questions related to the course content taught in 2019-2020*

*The relevant questions that I see fit to the course materials are **2a i) ii), 2b***

### 2a

*Note that the term **d** here is the power of f(n) in Master's Theorem*

1. $T(n)=aT(\frac{n}{b})+O(n^d)$

2. The third case, namely the case $f(n)=O(n^{E-\epsilon})$, gives the solution $T(n)=O(n)$.

   In this case, $d=\log_ba-1$

   We now using substitution to show this result:

   Let $ n=b^k$
   $$
   \begin{aligned}
   T(n) &= 2(2T(\frac{n}{2^2})+O(1))+O(1)\\
   &\approx 2^2T(\frac{n}{2^2})\\
   &= 2^kT(\frac{n}{2^k})\\
   &= 2^{\log_2n}T(1)\\
   &\approx nT(1)
   \end{aligned}
   $$
   which is $O(n)$

### 2b

1. $$
   f(x,1)=x\\
   f(x,n)=(f(x,\frac{n}{2}))^2, \mathrm{if\: n \: is \: even}\\
   f(x,n)=(f(x,\lfloor\frac{n}{2}\rfloor))^2 \cdot x, \mathrm{if\:n\:is\:odd}
   $$

2. We can see that the recurrence is:
   $$
   T(n)=T(\frac{n}{2})+O(1)
   $$
   Using master theorem, we can see that $E=\frac{\log1}{\log2}=0$, $f(n)=O(1)$. Because $f(n)=\Theta(n^E) $, the run time complexity of this function is $O(f(n)\log n)=O(\log n)$.

## 2013

**Note: there is no 150 Graph and Algorithm back in 2013, and the most relevant content is in class MC202 Software engineering - Algorithms. Note that this course is under JMC section. This solution only contains questions related to the course content taught in 2019-2020*

*The relevant questions that I see fit to the course materials are **2a, 2b, 2c, 2d***

### 2a

We start at node $A$.

| Iteration | Node Added      | Cost | Edge Added |
| --------- | --------------- | ---- | ---------- |
| 1         | A               | 0    |            |
| 2         | A B             | 1    | AB         |
| 3         | A B C           | 3    | BC         |
| 4         | A B C G         | 5    | CG         |
| 5         | A B C G D       | 6    | GD         |
| 6         | A B C G D H     | 7    | GH         |
| 7         | A B C G D H F   | 8    | GF         |
| 8         | A B C G D H F E | 12   | AE         |

### 2b

```python
def gcd(a,b):
  	if a == b:
      	return a
		if a == 1 or b == 1:
				return 1
		if a % 2 == 0 and b % 2 == 0:
				return 2*gcd(a/2, b/2)
    elif a % 2 == 1 and b % 2 == 1:
    		return gcd((a-b)/2, b)
    else:
      	return gcd(a,b/2) if a % 2 == 1 else return gcd(a/2,b)
```

### 2c

```python
##This is wrong, need to be fixed!
def kheadprob(n, k, prob_list):
  	memo = [1 for i in range(k)]
		for i in range(k):
        prob_list = prob_list[i:]
      	if i == 0:
          for j in range(k):
              memo[i] *= prob_list[j]
          for j in range(k, n):
              memo[i] *= (1 - prob_list[j])
      if i > 0:
          if n - i != k:
              memo[i] = memo[i-1] / (1 - prob_list[i-1]) * prob_list[i+1]
        
    return sum(memo)
      	
```



### 2d

TBD

