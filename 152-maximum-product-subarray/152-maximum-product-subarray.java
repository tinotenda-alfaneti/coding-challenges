class Solution {
    
    // Kadane's algorithm 
    public int maxProduct(int[] nums) {
        
        int minProd = nums[0];
        int maxProd = nums[0];
        int res = nums[0];
        
        
        for (int i = 1; i < nums.length; i++) {
            
            // if number is negative, swap max and min
            if (nums[i] < 0) {
                int tmp = maxProd;
                maxProd = minProd;
                minProd = tmp;
                
            }
            
            //keep track of both the minimum and the max
            maxProd = Math.max(maxProd * nums[i], nums[i]);
            minProd = Math.min(minProd * nums[i], nums[i]);
            
            res = Math.max(maxProd, res);
            
        }
        return res;
        
    }
}