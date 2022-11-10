/*
Available option are basically 3, rob the current house and the house after the previous one
or skip the current house and rob the previous house.

Get the maximum of those actions and return that.

*/

class Solution {
    public int rob(int[] nums) { 
        
        int res = recurseRob(nums, nums.length - 1, new HashMap<Integer, Integer>());
        return res;
        
    }
    
    public int recurseRob(int[] nums, int i, HashMap<Integer, Integer> memo) {
        if (i < 0)
            return 0;
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int ans = Math.max(recurseRob(nums, i - 2, memo) + nums[i], recurseRob(nums, i - 1, memo));
        memo.put(i, ans);
        return memo.get(i);
    }
}