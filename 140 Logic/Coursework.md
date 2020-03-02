# 140 Logic Coursework

## Coursework 1 - Syntax and Semantics of Propositional Logic

#### 1

- $(\rightarrow p\and \neg qr)$ is not a propositional formula because the left-hand side of $\rightarrow$ is not a formula(nothing).
- $p$ is a propositional formula because any propositional atom is a formula
- $p\or q\or r\or \top$ is strictly not a propositional formula because it does not have appropriate parenthesis
- $((p\rightarrow q)\or ((\neg p)\rightarrow r))$ is strictly a propositional formula
- $4\and 3=7$ is not a propositional formula because $=$ is not a propositional logic connective
- $p\ and\ q$ is not a propositional formula because $and$ is not a legal propositional connective
- $\neg r$ is not a propositional formula because a parentheisis is needed
- $(\neg r \rightarrow (p\rightarrow ((q\or r)\rightarrow (p\and \neg s))))$ is not a propositional formula beause both $\neg r$ and $\neg s$ need parenthesis
- $(\neg (p))$ is not a propositional formula, too many brackets
- $(\neg \neg \top)$ is not a propositional formula. One bracket is needed for the inner $\neg$
- $)$ is not a propositional formula because there is no legal atom/connective
- $(\neg(\neg(\neg(\neg(\neg p)))))$ is a propositional formula

In total: 2, 4, 12 are strictly propositional formulas and others are not.

#### 2

- After removing: $(p\or (q\and r))$
- After removing: $(p\or q)\and r$
- After removing: $\neg (p\and q)$
- After removing: $p\rightarrow (q\rightarrow r)$
- After removing: $\neg p\and q\rightarrow r$
- After removing: $\neg (p\and q)\rightarrow r$
- After removing: $\neg \neg p$
- After removing: $p\or (\neg q \leftrightarrow (\neg (r\and \neg p)\rightarrow \bot))$
- 

#### 3

+ Assume that we have no binding conventions at all:
  * $(A\or B)\and C$ or $A\or (B\and C)$
  * $A\or (B\and C)$, only one interpretation
  * $(\neg B)\rightarrow C$ or $\neg (B\rightarrow C)$
  * $(\neg B)\and C$ or $\neg (B\and C)$
  * $(A\rightarrow \neg B)\and C$ or $A\rightarrow ((\neg B)\and C)$ or $A\rightarrow \neg (B\and C)$
  * $(A\rightarrow B)\leftrightarrow C$ or $A\rightarrow (B\leftrightarrow C)$
  * $(A\rightarrow B)\rightarrow C$ or $A\rightarrow (B\rightarrow C)$
  * $(A\leftrightarrow B)\leftrightarrow C$ or $A\leftrightarrow (B\leftrightarrow C)$
  * $\neg ((\neg B)\and C)$ or $\neg (\neg (B\and C))$ or $(\neg \neg B)\and C$
  * $(\neg A)\rightarrow (\neg B)$ or $\neg (A\rightarrow (\neg B))$
  * $(A\and B)\and C$ or $A\and (B\and C)$
  * $A\rightarrow \neg ((\neg B)\or C)$ or $A\rightarrow \neg (\neg (B\or C))$ or $(A\rightarrow \neg \neg B) \or C$

- Assume that we have the binding conventions:
  - $A\or (B\and C)$
  - the same as the first one
  - $(\neg B)\rightarrow C$
  - $(\neg B)\and C$
  - $A\rightarrow ((\neg B)\and C)$
  - $(A\rightarrow B)\leftrightarrow C$
  - $(A\rightarrow B)\rightarrow  C$ or $A\rightarrow (B\rightarrow C)$
  - $(A\leftrightarrow B)\leftrightarrow  C$ or $A\leftrightarrow (B\leftrightarrow C)$
  - $(\neg \neg B)\and C$
  - $(\neg A)\rightarrow (\neg B)$
  - $(A\and B)\and C $ or $A\and (B\and C)$
  - $A\rightarrow ((\neg \neg B)\or C)$

#### 4

- Construction tree:

  ```mermaid
  graph TD
  imply --- p
  imply --- and
  and --- q
  and --- r
  ```

  Subformulas: $p$, $q$, $r$, $q\and r$, $p\rightarrow q\and r$. Literals: $p$, $q$, $r$. No clauses here.

- Construction tree:

  ```mermaid
  graph TD
  iff --- or
  iff --- and
  and --- not
  not --- p
  and --- q
  or --- r
  or --- s
  ```

  Subformulas: $p$, $q$, $r$, $s$, $\neg p$, $\neg p\and q$, $r\or s$, $\neg p\and q\leftrightarrow r\or s$. Literals: $p$, $q$, $r$, $s$, $\neg p$. Clauses: $r\or s$

- Construction tree:

  ```mermaid
  graph TD
  imply1[imply] --- or
  imply1 --- not
  or --- and
  or --- r
  and --- p
  and --- q
  not --- imply2[imply]
  imply2 --- p2[p]
  imply2 --- r2[r]
  ```

  Subformulas: $p_1$, $q$, $p_2$, $r_1$, $p_1\and q$, $p_1\and q\or r_1$, $p_2\rightarrow r_2$, $\neg (p_2\rightarrow r_2)$, $p_1\and q\or r_1\rightarrow \neg (p_2\rightarrow r_2)$

  Literals: $p_1$, $q$, $p_2$, $r_1$. No clauses here.

Omit the rest of the problems for question 4

#### 5

- $(\top\rightarrow \top)\rightarrow \neg \top$ evaluates to false.
- The second one evaluates to true.
- The third one evaluates to false.

#### 6

- The first one evaluates to false
- The second one evaluates to false
- The third one evaluates to true

#### 7

Omit this question

## Coursework 2 - First-Order Logic

#### 1

Omit the first question

#### 2a

- The first one is false because B sees C but A is not seeing B
- The second one is true because B is next to D
- The third one is true because F above A is false, and after negation the result is true
- The fourth one is true because A sees E is false, and fater negation the result is true
- The fifth one is true because the formula after the implication is always true

#### 2b

We omit the answer for 2b

#### 3

We omit the answer for 3

#### 4

- Everything is either inside the box or on the table
- Everything on the table is red and every green thing is in the box
- Nothing is both green and red

#### 5

We omit the diagram

- The first is true because $Felix$ the cat is indeed chasing itself
- The second is true because $Felix$ is chasing itself
- The third is false because the cat chases worm does not imply worm chases cat
- The fourth is true because cat is chasing itself and so does worm
- The fifth is false because no other things chase cat other than itself
- This is translated into "something is chased by everything". This is true since worm is chased by all three.
- This one is false because cat chases worm but worm does not chase cat
- This is translated into "everything is chased by something". This is true since cat chases all three

## Coursework 3 - Semantics of First-Order Logic

#### 1

$(C)$ is to $(a)$, $(F)$ is to $(b)$, $(H)$ is to $(c)$, $(A)$ is to $(d)$, $(D)$ is to $(e)$, $(G)$ is to $(f)$, $(B)$ is to $(h)$

$(E)$ translates to $\forall x (triangle(x) \rightarrow \neg \exist y(triangle(y)\and (left\_of(x,y)\or left\_of(y,x))))$

$(g)$ translates to Everything is either a circle or not at the top right corner

$(a), (E), (b)$ are true in struction $M$

#### 2

- We have to adjust the height of one student so that all of the staff are much taller than him/her
- We cannot achieve this statement unless we remove all the students from DoC
- We just need to ensure that there is one student who is much taller/shorter than other students
- We cannot avhieve this statement unless we remove all the staff from DoC

#### 3a



