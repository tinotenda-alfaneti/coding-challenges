
class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 1, majElem = nums[0];
        
        
        for(int i = 1; i < nums.length; i++) {
            
            if (nums[i] == majElem) {
                count++;
            } else if (nums[i] != majElem && count != 0) {
                count--;
            } else if (nums[i] != majElem && count == 0) {
                majElem = nums[i];
                count = 1;
            }
        }
        
        return majElem;  
        
    }
}