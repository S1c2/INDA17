If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

| Operation | Unsorted Array | Sorted Array | Unsorted SLL | Sorted SLL | Hash table (Average)| Hash table (Worst) |
|-----------|----------------|--------------|--------------|------------|----------------|-------------------|
| Find      | O(n)           | O(log n)     | O(n)         |O(n)        | O(1)           |  O(1)             |
| Insert    | O(n)           | O(1)         | O(1)         |O(1)        | O(1)           |  O(1)             |
| Remove    | O(n)           | O(1)         | O(n)         |O(n)        | O(1)           |  O(1)             |


Unsorted array:
1. If we have to find the last one
2. If we have to shift everything
3. Same as above

Sorted array:
1. Binary search
2. We already know the index 
3. Same as above

Unsorted SLL
1. When we don´t have the location of the last node
   Have to go through each element
2. We only have to re-point a node to the inserted node
3. Same as above : re-pointing nodes

Sorted SLL
Same as above

Hashtable (average/worst)
- as done in this exercise, O(1) for all cases because we can access and calculate the index directly


Answer the following:

1. What is the initial capacity of an `ArrayList`'s internal array?

10

You can find it here:

Default initial capacity.
113 
114     private static final int DEFAULT_CAPACITY = 10;

2. At what size does the internal array grow, and by how much?

When the size is larger than 10. The capacity grows by approximately 50%.
255         int newCapacity = oldCapacity + (oldCapacity >> 1);

">>" is the right shift operator. It shifts a bit pattern to the right. ">>1"
means that the shift operator shifts it one time and thus we add oldCapacity/2
e.g. 1100 >> 1 becomes 0110 
i.e. 12 to 6

3. Explain what really happens by the term "grow" in this context?

"It´s capacity grows"

"Each ArrayList instance has a capacity. 
The capacity is the size of the array used to store the elements in the list. 
It is always at least as large as the list size. 
As elements are added to an ArrayList, its capacity grows automatically. 
The details of the growth policy are not specified beyond the fact that adding an element has constant amortized time cost."

4. What is the capacity of the internal array once 20 elements have been added?

22

10 + 15 + 7
The capacity always grows by 50%

5. If objects were removed, would the size of the internal array change also?

There is no indication in the documentation that the size changes

6. What is the worst, average, and best-case time complexity of the `add(E e)`
   method of `Arraylist`?
   
   Best case : O(1)
   
   Average case : O(1)
   
   Worst case : O(n)
