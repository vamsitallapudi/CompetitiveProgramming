### DFS With Sorting

We'll sort according to height of each node.

We'll store a pair at each node with values - (height, val).

Later we'll iterate by height and add all pairs list to the returning list

### Time Complexity
Sorting N Nodes - O(NLogN)
Traversing N Nodes - O(N)

Therefore, Total Time Complexity - O(NLogN)

### Space Complexity

O(N Log N) as space is used by pairs and solution.