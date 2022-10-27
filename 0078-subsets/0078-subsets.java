/*
Given [1, 2, 3]
[] => 000 
[1] => 100
[2] => 010
[3] => 001
[1,2] => 110
[1,3] => 101
[2,3] => 011
[1,2,3] => 111
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> finalRes = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < (int) Math.pow(2, n); i++) {
            List<Integer> subset = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                
                //mask to look for positions with 1
                if (((i >> j) & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            finalRes.add(subset);
        }
        return finalRes;
        
    }
}