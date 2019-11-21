If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

| Size (n)   | MatrixGraph | HashGraph |
| ---------- | ----------- | --------- |
| 100        | 5981405 ns  | 4226247 ns         |
| 400        | 12081620 ns | 6895989 ns      |
| 1600       | 15924452 ns | 8495082 ns   |
| 6400       | 48908265 ns | 24991720 ns    |

HashGraph is faster because the worst-case asymptotic look-up for an object is O(n) meanwhile it is O(n^2) for the adjacency list in MatrixGraph