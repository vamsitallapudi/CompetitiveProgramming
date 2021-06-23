Here we need to perform:
    1. check if key exists,
    2. put the key,
    3. Delete the first added key

First 2 operations can be done in - O(1) time - using HashMap
Deletion of first added element - Cannot track first added in HashMap due to unordered and cannot access via position
Best way to do 3. is using DLL or deque.

Time Complexity - O(1) for Get and Put operations

Space Complexity - O(capacity)