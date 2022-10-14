/*
1. Cycle detection in a linked list problem
    - consider each element to be pointing to another element except the 0.
    -
      [0,1,2,3,4]
      [1,3,4,2,2]
    
                1 -> 3 -> 2
                         / \
    -                    \ /
                          4
    - Hence since there is always going to be a cycle (repeated values) we use
                    FLOYD'S CYCLE DETECTION
    - HOW?
        initialize two pointers - slow -> one step at a time 
                                  fast -> two steps at a time
        After these two pointers collide, we stop and initialize the second slow pointer
            - will start at the beginning
            WHY? - According to Floyd's algorithm - the distance between
            where the cycle started and where the fast and slow collided is equal to
            the distance between the head node and where the cycle started.
            Therefore, the collision of the slow1 and slow2 will be the repeated value
            The concept can be proved with algebra.
    - After that we just return any of the slow pointers
    - Runtime - O(n), space - O(1)
    - For the record, I on my own could not have came up with that
        - My approach was to use a set. Loop through the array and anytime i fail
        to put an element, l just return that element because it will be the repeated one
        - Another approach was to mark the index as visited everytime l find an element for that
        index, and when l come accross that index again l will just return the current element.

*/
