class Solution {
    public int jump(int[] nums) {
        
        int l = 0, r = 0;
        int jumps = 0;
        
        while (r < nums.length - 1) {
            
            int farRight = 0;
            
            for(int i = l; i < r + 1; i++) {
                farRight = Math.max(farRight, i + nums[i]);
            }
            
            l = r + 1;
            r = farRight;
            jumps++;
        }
        
        return jumps;
       
        
    }
}