If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

## Exercise 1 : calculate and fill in


| Size / complexity |     log n     |       n       |    n log n    |  n<sup>2</sup>   |  n<sup>3</sup>   |   2<sup>n</sup>  |      n!          |
|-------------------|---------------|---------------|---------------|------------------|------------------|------------------|------------------|
| 1                 |0             |1               | 0              |1                  |1                  |2               |1                  |
| 10                |3.3         |10               |33               |100                 |1000              | 1024           |3628800                  |
| 100               |6.64         |100              |664               |10000              |1e6               |1e30            |9e157                  |
| 1000              |9.966         | 1000          | 9966             | 1e6              | 1e9              | 1e301            | 4e2567           |
| 10000             |13.288        |10000           |13288             |1e8               |1e12             |1e3010             |2e35659                  |
| 100000            |16.60964        |100000         |1660964           |1e10             |1e15           |9e30102              |2e456573                  |
| 1000000           |19.931568       |1000000         |19931568         |1e12             |1e18           |9e301029             |8e5565708                  |

## Exercise 2 : set T(n) = the amount of time in nanoseconds = function (e.g. n log n) and solve for n

| T(n)          | 1 second | 1 minute |  1 hour  |  1 day   |  1 year  |
| --------------|----------|----------|----------|----------|----------|
| log n         |&#x221e;  |&#x221e;  | &#x221e; |3.98e13   |1.05e17   |
| n             |1e9       |6e10      | 3.6e12   |8.64e13   |3.15e16   |
| n log n       |3.96e7    |4.46e5    | 9.8e10   |2.11e12   |6.41e14   |
| n<sup>2</sup> |3.16e4    |2.45e5    | 1.8e6    |9.3e6     |1.8e8     |
| n<sup>3</sup> |1e3       |3.9e3     | 15326    |44208     |315952    |
| 2<sup>n</sup> |29        |36        | 41       |46        |55        |
| n!            |12.3      |13.9      | 15       |16        |17        |

## Exercise 3 : f(n) and g(n) - if f(n) = O(g(n)) it means that f(n) grows faster than g(n)

Arrange the functions in the following list in ascending order based on their
rate of growth. That is, the function f(n) should come before the function g(n)
in the list if f(n) is O(g(n)).

f4(n) = n + 100 (will compute in only 1 step each time so O(1))

f3(n) = n log n  (for larger values of n, log(n) becomes less significant so O(n)

f1(n) = n<sup>1.5</sup>

f5(n) = 2<sup>n</sup> (2<sup>n</sup> is faster than 10<sup>n</sup>)

f2(n) = 10<sup>n</sup>


Which of the following statements are true? Justify your answer.

#### n (n + 1) / 2 = O(n<sup>3</sup>)
- The tight O-estimation is O(n^2) and therefore it is O(n^3) as it is bigger

#### n (n + 1) / 2 = O(n<sup>2</sup>)

- For polynomials) : we first remove the lower orders (n/2 in this case) - we´re then left with (n<sup>2</sup>)/2 and then I remove the constant (1/2 in this case), so I am left with O(n<sup>2</sup>)

n (n + 1) / 2 = Θ(n<sup>3</sup>)

#### false 

#### n (n + 1) / 2 = Ω(n)

- There is a k such that kn is below n (n + 1) / 2

## Exercise 4

Give a tight O-estimation, as a function of n, of the worst case time
complexity of the following five loops:

```
Algorithm Loop1(n):
   a = 0
   for i = 1 to n
      a += i
```
### O(n)

```
Algorithm Loop2(n):
   b = 1
   for i = 1 to 4n
      b++
```
### O(n)
```
Algorithm Loop3(n):
   c = 1
   for i = 1 to n^2
      c--
 ```
 ### O(n^2)
```
Algorithm Loop4(n):
   d = 5
   for i = 1 to 3n
      for j = 1 to i
         d = d + j
```
### O(n^2)

```

Algorithm Loop5(n):
   e = 5
   for i = 1 to n^2
      for j = 1 to i
         e = e + j
```
### O(n^4)

## Exercise 5

Explain why (n+1)<sup>3</sup> is O(n<sup>3</sup>). Use the following
definition: f(n) is O(g(n)) if there exists positive constants c and
n<sub>0</sub> such that f(n) &le; c &times; g(n) for all n &ge; n<sub>0</sub>.

c*n^3 is bigger than (n+1)^3 if the constant is bigger than 1

## Exercise 6
The following algorithm reverses a collection.  Answer the following:

```python
Reverse (A):
   # Input: an array A storing n elements.
   # Output: the same array with the elements in reversed order.
   for i = 1 to n-1
       x = A[i]
       for j = i down to 1
           A[j] = A[j-1]
       A[0] = x
```

- What is the basic operation for this algorithm?
### Answer : A[j] = A[j-1]
- Describe the time complexity of this algorithm
### Answer : The time complexity is quadratic 


#### Exercise 7
Insertion Sort and Selection Sort have similar worst case runtime complexity
O(n<sup>2</sup>).  Explain:

- How they differ in best case (a sorted collection) and mostly sorted case in
  terms of the runtime complexity of each algorithm, and
- Which should be preferred as a sorting algorithm with justification.

Selection sort does better for random data (as demonstrated in the lecture), it also works better for reversed data(worst case). Insertion sort uses a lot more swaps and the runtime is longer. Insertion sort is better when the collection is already sorted(best case), or a little bit sorted. So why do we want to use insertion sort? In real life our data is often "almost" sorted and in that case insertion sort is the better option.


