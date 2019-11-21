If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)


#### Exercise 8.12 (10.12)
Assume that we have four classes: `Person`, `Teacher`, `Student`, and
`PhDStudent`. `Teacher` and `Student` are both subclasses of `Person`.
`PhDStudent` is a subclass of `Student`.

a. Which of the following assignments are legal, and why or why not?

```java
Person p1 = new Student();
 - legal because Student is a subclass of Person
Person p2 = new PhDStudent();
 - legal because PhDStudent is a subclass of Person
PhDStudent phd1 = new Student();
 - illegal, Student is not a subclass to PhDStudent, thus when I instantiate a new Student object, it cannot be of type PhDStudent
Teacher t1 = new Person();
 - illegal, Person is not a subclass to Teacher
Student s1 = new PhDStudent();
 - legal, PhDStudent is a subclass of Student
```

b. Suppose that we have the following legal declarations and assignments:

```java
Person p1 = new Person();
Person p2 = new Person();
PhDStudent phd1 = new PhDStudent();
Teacher t1 = new Teacher();
Student s1 = new Student();
```

Based on those just mentioned, which of the following assignments are legal,
and why or why not?

```java
s1 = p1;
- illegal. Student is a subclass of Person.
s1 = p2;
- illegal for the same reason as mentioned above
p1 = s1;
- legal
- I cannot assign a class which is more specific to a class that is less specific
```

#### Exercise 8.14 (10.14)
What has to change in the `NewsFeed` class when another `Post` subclass (for
example, a class `EventPost`) is added? Why?

Nothing has to change in a superclass when a subclass is added. The subclasses inherit
the characteristics of the superclass.

#### Exercise 8.15 (10.15)
Exercise 8.15 Use the documentation of the Java standard class libraries to
find out about the inheritance hierarchy of the collection classes. Draw a
diagram showing the hierarchy.

SEE PICTURE
source : https://docs.oracle.com/javase/7/docs/api/

#### Exercise 8.16 (10.16)
Go back to the lab-classes project from Chapter 1. Add instructors to the
project (every lab class can have many students and a single instructor). Use
inheritance to avoid code duplication between students and instructors (both
have a name, contact details, etc.).

#### Exercise 8.XX
Below are two algorithms that calculate x<sup>n</sup>, where x is a real number
and n is a non-negative integer. You are to:

**a.** Argue the correctness of the algorithms using a loop invariant or proof
by induction.

**b.** Calculate the time-complexity as a function of n for both algorithms.
Give the result using Big-O notation.

```java
double expIterative(double x, int n) {
    double res = 1.0;

    for (int i = 0; i < n; i++) {
        res *= x;
    }
    return res;
}
```
> **Assistant's note:** Try to find a correlation between the loop counter `i`
> and the `res` variable. A loop invariant is most appropriate for this
> algorithm.

Answer : Using a loop-invariant we want to prove that res outputs x^n correctly. We can see that in the loop, res is equal
to res*x^0 = 1(*)1 = 1 , x*(1), x*(x*1), x(x*x*1) ... x^n
- the formatting becomes weird here, I don´t know why

AKA

res  = 1, x^1, x^2,... until we finally arrive at x^n

```java
double expRecursive(double x, int n) {
    if (n <= 4) {
        return expIterativ(x, n);
    }

    return expRecursive(x, n/2) *
           expRecursive(x, (n + 1)/2);
}
```
> **Assistant's note:** Even if you haven't managed to complete the previous
> proof, assume that `expIterative(x, n)` has been proven to be correct for any
> x &#8712; **R** and `n >= 0`. Furthermore, remember that integer divison
> always rounds off toward 0, and consider the two cases when `n` is odd and
> when `n` is even.  A proof by induction is most appropriate for this
> algorithm.

Answer : Using proof by induction. We have already proved the iterative method so we
start with n=5. Because integer division rounds off towards zero we get expRekursiv(x,2)expRekursiv(x,3)
which goes into the iterative method as n is smaller than 4. And we get x^2*x^3=x^5 which is what we wanted. We also
show for an even n = 6, which gives us expRekursiv(x,3)expRekursiv(x,3) = x^6 which is also what we want.
We assume true for x=p and want to prove for x = p+1. The assumption is that expRekursiv(x,p/2)expRekursiv(x,(p+1)/2)
= x^p. And we want to show that expRekursiv(x,(p+1)/2)expRekursiv(x,(p+2)/2) = x^(p+1).
If n is even, n/2 is also even, and there is no change to number in the division. However, if n is odd, we can
subtract 1/2 as the number will be rounded down to 0.


Answer to the time complexity problem:

The master theorem gives us the formula aT(n/b) + f(n)
- f(n) = n^d for some constant d
- n is the size of the input
- a and b are constant larger than 1 (a can be equal to 1)

Considering f(n) to be the iterative operations, they will work a maximum of 4 times and therefore f(n) = 1 is constant, meaning d = 0
It calls upon itself 2 times in the recursive part meaning that a = 2 and while calling itself n is divided by 2, so b = 2

The master theorem says that if a > b^c then T(n) = Θ(nlog(b)a)

2>2^0

T(n) = Θ(nlog(2)2) = Θ(n)

