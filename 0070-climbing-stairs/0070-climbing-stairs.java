
/*
Bottom-up dynamic programming approach
    - The number of steps from n to n is 1 and the number of steps from n-1 to in is 1
    - However, the number of steps for n-2 will be n + (n-1)
    - Hence we can store the previous two values in an array and use them to compute the next
    - And when we get to zero we just return the addition of the previous two
    - e.g   n = 3
    ptrN = 5 -> 2, ptrNless1 = 4 -> 1
    i = 1
    when i = 0 -> 3
    
    n = 2
    ptrN = 5 -> 1, ptrNless1 = 4 -> 1
    i = 0
    
    when i = 0 -> 8
    
 Another approach is to use DFS with memoization to store the already calculated steps
 Say for three, we know that it is going to be 3, for 5 it's going to be 8
 Memoization reduces the runtime from 2^n to n.
    
*/
class Solution {
    public int climbStairs(int n) {
        
        if (n == 1) {
            return n;
        }
        
        int ptr1 = 1;
        int ptr2 = 1;
        
        for (int i = n - 2; i > 0; i--) {
            int currTotal = ptr1 + ptr2;
            ptr2 = ptr1;
            ptr1 = currTotal;
            
        }
        
        return ptr1 + ptr2;
    }
}