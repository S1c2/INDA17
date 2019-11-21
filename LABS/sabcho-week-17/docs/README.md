If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

### Task 2 - Time Complexity
Calculate the worst-case time complexity for all operations of the BST and
complete the table below.  As usual, motivate your answers.

| Operation (BST)     | Time Complexity (worst case)    |
| ------------------- | ------------------------------- |
| search              |O(n)                                 |
| insert              |O(n)                               |
| size                |O(1)                                |
| height              |O(n)                                 |
| leaves              |O(n)                                 |
| toString            |O(n)                                |


Worst cases
* Search : if what we are searching for is at the deepest level
* Insert : if the node we want to insert ends up at the deepest level
* Size : is always updated when a new node is added - so we can immediately retrieve the size when asking for it
* Height : every recursive call gives us two problems (left and right) of half the size - according to the master theorem, this evaluates to O(n)
* leaves : to count the leaf nodes we have to visit each node in the tree
* toString : we will iterate over each node 1 time