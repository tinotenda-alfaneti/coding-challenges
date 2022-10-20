/*
# A modification of the two sum
Sort the array 
The loop through the array with three pointers
    1 going through the array normally
    1 starting from the end
    1 starting next to the first
Keep track of the prev sum and if the current sum is closer to the target, update the prev
move the 2nd pointer if the the curr sum is less than target
move the last pointer if the curr sum is greater than the target
return the prev
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int prevSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = nums.length - 1;
            
            while (L < R) {
                int currSum = nums[i] + nums[L] + nums[R];
                
                if (Math.abs(currSum - target) < Math.abs(prevSum - target)) {
                    prevSum = currSum;
                }
                
                if (currSum == target) return currSum;
                
                if (currSum > target) R--;
                if (currSum < target) L++;
            }
        }
        
        return prevSum;
        
    }
}