class Solution {
    public int maxSubArray(int[] nums) {
        
        int currSum = 0;
        
        int res = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            res = Math.max(currSum, res);
            
            if (currSum < 0) currSum = 0;
                
        }
        
        return res;
    }
}