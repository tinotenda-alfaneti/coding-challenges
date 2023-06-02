
class Solution {
    public int removeElement(int[] nums, int val) {
        
        int p2 = nums.length - 1, p1 = 0, k=0;
        
        while (p1 <= p2) {
            
            if (nums[p1] == val && nums[p2] != val) {
                nums[p1] = nums[p2];
                nums[p2] = Integer.MAX_VALUE;
                p2 --;
                k++;
                
            } else if (nums[p2] == val) {
                nums[p2] = Integer.MAX_VALUE;
                p2 --;
                k++;
                continue;
            }
            p1++;
        }
        return nums.length - k;
        
    }
}