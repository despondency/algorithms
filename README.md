![alt text](https://travis-ci.org/despondency/algorithms.svg?branch=master)


This is an algorithms collection and is aimed to have one file per algorithm, no dependencies on other files for easier understanding. 

**Search for algorithm implementation here and use Find File, to stay sane of packaging.**

Some algorithms are buried into their own packages since i try to make all algorithms one file per algorithm, so Edge class for instance will be repeated in several algorithms, so every each one of these is subpackaged because it's not allowed to have same class in different class files of the same package.

**Algorithms without test are usually ones that will have to break the algorithm routine and add additional unneeded memory/complexity constraints to write a test. For instance : BFS, DFS.**

Currently implemented algorithms 


|id  | Algorithm                                | Test                                   | 
|----| -----------------------------------------|:--------------------------------------:|
|1   | MergeSort                                |     YES                                |
|2   | QuickSort                                |     YES                                |
|3   | SelectionSort                            |     YES                                |
|4   | InsertionSort                            |     YES                                |
|5   | BubbleSort                               |     YES                                |
|6   | CountingSort                             |     YES                                |
|7   | LevenshteinEditDistance                  |     YES                                |
|8   | LongestCommonSubstringDP                 |     YES                                |
|9   | NaiveSuffixArray                         |     YES                                |
|10  | BFS                                      |     NO                                 |
|11  | DFS                                      |     NO                                 |
|12  | ConnectedComponents                      |     YES                                |
|13  | KosarajuSharir                           |     YES                                |
|14  | QuickFind                                |     YES                                |
|15  | WeightedQuickUnionFindPathCompression    |     YES                                |
|16  | Kruskal                                  |     YES                                |
|17  | Prim                                     |     YES                                |
|18  | TopologicalSort                          |     YES                                |
|19  | Boruvka                                  |     YES                                |
|20  | Dijkstra                                 |     YES                                |
|21  | DAGShortestPaths                         |     YES                                |
