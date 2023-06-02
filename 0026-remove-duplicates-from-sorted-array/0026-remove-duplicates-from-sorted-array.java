
class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 1) return 1;
        
        int p1 = 0, k=0;
        
        for (int p2 = 1; p2 < nums.length; p2++) {
            
            if (nums[p1] != nums[p2] && p2 - p1 == 1) {
                p1++;
                
            } else if (nums[p1] != nums[p2]) {
                nums[++p1] = nums[p2];
                nums[p2] = 101;
                k++;
            }
        }
        return p1 + 1;
        
    }
}