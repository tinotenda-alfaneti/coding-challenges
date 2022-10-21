/*
0 + 2 + 3 = 5
n = 3
n(n+1)/2 = (3)(4) / 2 = 6
Therefore the missing number is going to be the 
   sum of all elements in the array - summation of the series
*/
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int currSum = 0;
        int expectedSum = (n*(n+1))/2;
        
        for(int num : nums) {
            currSum += num;
        }
        
        return expectedSum - currSum;
        
        
    }
}