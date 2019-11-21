If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

#### Exercise 9.11 (11.11)
Assume that you see the following lines of code:

```java
Device dev = new Printer();
dev.getName();
```

`Printer` is a subclass of `Device`. Which of these classes must have a
definition of method `getName` for this code to compile?

Answer : The Device class must have a definition of the method getName()

#### Exercise 9.12 (11.12)
In the same situation as in the previous exercise, if both classes have an
implementation of `getName`, which one will be executed?

Answer : The implementation in the Device class will be executed
It will override the getName() method in the Printer class

#### Exercise 9.13 (11.13)
Assume that you write a class `Student` that does not have a declared
superclass. You do not write a `toString` method. Consider the following lines
of code:

```java
Student st = new Student();
String s = st.toString();
```

Will these lines compile? If so, what exactly will happen when you try to
execute?

It will compile but it will return an ugly string Student@(Hashcode thingy) with the hashcode of the object in hexadecimal (happened to me in week 8 - Game)

#### Exercise 9.14 (11.14)
In the same situation as before (class `Student`, no `toString` method), will
the following lines compile? Why?

```java
Student st = new Student();
System.out.println(st);
```

Yes, because println() calls the objects toString() method. All java objects have one.

#### Exercise 9.15 (11.15)
Assume that your class `Student` overrides `toString` so that it returns the
student's name. You now have a list of students. Will the following code
compile? If not, why not? If yes, what will it print? Explain in detail what
happens.

```java
for (Object st : myList) {
    System.out.println(st);
}
```

Yes, the code will compile. It will return the student names, each on a new line.

#### Exercise 9.16 (11.16)
Write a few lines of code that result in a situation where a variable `x` has
the static type `T` and the dynamic type `D`.

Private static D somethingOfTypeD;
somethingOfTypeD = new T();

- the static variable has reserved characteristics at runtime
- the characteristics of the dynamic variable are created upon runtime



### Task 2 - Linked Lists
A list, a number of elements ordered in a linear structure, is perhaps the
simplest and most elementary data structure. Java provides several variants of
lists:

* The standard `array` (`int[]` for example) has hardware support, but is
  simple and somewhat limited. In memory, the elements must come one after
  the other in order (by index).

* `ArrayList` is implemented using an array, but has added functionality Just
  like with the `array`, the elements must be ordered in memory (by index).

* `LinkedList` which has largely the same functionality as ArrayList but
  different performance qualities. The elements do not have to come one after
  another in memory.

A singly linked list can be seen as a set of containers (which we will refer to
as _elements_ from now on) with two buckets each:
one that holds the element's value, and one that holds a reference to the
next element. A huge benefit of this is that the elements can be stored in
arbitrary locations in memory (i.e. they don't have to follow each other).

The data structure itself usually only knows where the first element (the
_head_) and the last element (the _tail_) are located, as well as how many
elements are currently in the list. It may look something like this (but
remember that elements are not necessarily ordered _in memory_, the may be
located all over the place).


```
     ----------        ----------        ----------
    |     |    |      |     |    |      |     |    |
--->|  2  |  -------->|  2  |  -------->|  1  |null|
    |     |    |      |     |    |      |     |    |
     ----------        ----------        ----------
```

The elements can be implemented as objects with two instance variables
containing the value of the node and a reference to the next element in the
list:

```java
private static class ListElement<T> {
    public T data;
    public ListElement<T> next;
    
    public ListElement(T data) {
        this.data = data;
        this.next = null;
    }
}
```
Note that the fields of `ListElement` are `public`, so they are meant to be
accessed directly (e.g. with `elem.data`), and not via getter/setter.

A _doubly_ linked list would also have a reference to the previous element, but
that slightly complicates some operations, so we will stick to a singly linked
list this time around.

##### You are to complete the following tasks:

1. Implement a singly linked list. A code skeleton can be found in the file
   [src/LinkedList.java](src/LinkedList.java). You are not allowed to change the
   API of the class. That is to say, you are not allowed to modify the
   signatures of the public methods in the class `LinkedList`, or add any new
   public methods.  Be sure to read through the method comments thoroughly!

2. Calculate the asymptotic worst-case-time for all public methods in your
   implementation. Express the time as a function of the number of elements `n`
   in the list. Put your answers in [`docs/README.md`](docs/README.md)
   
   Answer :
   
   All methods are O(1) except for public String toString() and
   public T get(int index) that are O(n)

### Testing
Testing this week is important, and can be somewhat difficult. It is doubly
recommended here to _implement the tests first_. The majority of the unit tests
attempt to assert one of four invariants:

1. size equals the number of list elements,
2. if size == 0, first == null and last == null,
3. if size > 0, first != null and last != null,
4. if size == 1, first == last,

A 5th invariant, that is difficult to test without exposing too much of the
data structure, can be good to have in mind:

5. last.next == null

Use the `removeElements` helper method for the tests that require removal of
elements (except if it is explicitly stated that clear should be used!). As
usual, you are to implement all tests with a `fail` statement.
