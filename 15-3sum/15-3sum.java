import java.util.Arrays;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int L = i + 1;
            int R = nums.length - 1;
            
            while (L < R) {
                ArrayList<Integer> temp = new ArrayList<>();
    
                int sum = nums[i] + nums[L] + nums[R];
                
                if (sum < 0) {
                    L++;
                    
                }
                else if (sum > 0) {
                    R--;
                    
                }
                else {
                    temp.add(nums[i]);
                    temp.add(nums[L]);
                    temp.add(nums[R]);
                    result.add(temp);
                    L++;
                    while(nums[L] == nums[L-1] && L < R) L++;
                    
                }
                
            }
        }
        
        
        return result;
    }
}