/*
Similar to house robber 1 but in this case if we choose house 1, we skip the last one
Therefore we just call the house with the two arrays, the one which includes the
last one the one that does not include the last one and then compute the maximum
*/
class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(getRobSum(nums, 1, nums.length), getRobSum(nums, 0, nums.length - 1));
        
    }
    
    public int getRobSum(int[] nums, int start, int end) {
        int house1 = 0, house2 = 0;
        
        for (int i = start; i < end; i++) {
            int temp = Math.max(house1 + nums[i], house2);
            house1 = house2;
            house2 = temp;
        }
        return house2;
    }
}