/*

n >>= 1 shifts the bit value by 1, like dropping the last value
>> for shifting
& works just the same way as the AND for truth tables

We can use a bit mask to make the process faster by using n & (n - 1)
That makes it only look for places where we have 1s only

The runtime is O(log n)
The space is O(1)
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int weight = 0;
        
        while (n != 0) {
            weight ++;
            n = n & (n - 1);
        }
        
        return weight;
        
    }
}