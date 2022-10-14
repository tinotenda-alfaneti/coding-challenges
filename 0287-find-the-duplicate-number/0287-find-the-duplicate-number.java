// Check notes about this approach
// Floyd's cycle detection

class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = 0, fast = 0, anotherSlow = 0;
        
        
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        while (slow != anotherSlow) {
            slow = nums[slow];
            anotherSlow = nums[anotherSlow];
        }
        
        return slow;
        
    }
}

