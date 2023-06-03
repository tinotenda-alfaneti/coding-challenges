class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 1) return 1;
        
        int i = 0, count = 1;
        
        for(int j = 1; j < nums.length; j++) {
            
            if (nums[j] == nums[i] && count < 2) {
                count += 1;
                
            } else if (nums[j] == nums[i] && count >= 2) {
                nums[j] = Integer.MAX_VALUE;
                continue;
            } else if (nums[j] != nums[i]) {
                count = 1;
            }
                
           nums[++i] = nums[j];     
        }
        
        return i + 1;
    }
}