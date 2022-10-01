class Solution {
    
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        
        int currSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : nums) {
            currSum = Math.max(currSum, 0); // if the previous sum is negative, throw it away
            currSum += num; // increment the sum
            maxSum = Math.max(maxSum, currSum); // update the max
            
        }
        return maxSum;
    }
        
}