class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int target = -1 * nums[i];
            int start = i+1;
            int end = n - 1;
            
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i],
                          nums[start],
                          nums[end])));
                    start++;
                    
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                } else if (sum > target) {
                    end --;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}