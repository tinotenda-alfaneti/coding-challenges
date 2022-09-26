class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length -1;
        int[] res = {-1, -1};
        
        if (nums.length == 1 && nums[0] == target) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        
        if (nums.length == 1 && nums[0] !=target) {
            return res;
        }
        
        while (left <= right) {
            int mid = (left + right)/2;
            int midVal = nums[mid];
            
            if (midVal == target) {
                int i = mid, j = mid;
                
                while(i < nums.length && nums[i] == target) {
                    i += 1;
                }
                
                while(j >= 0 && nums[j] == target) {
                    j -= 1;
                }
                
                res[1] = i - 1;
                res[0] = j + 1;
                break;

            }
            
            if (midVal > target) {
                right = mid - 1;
            }
            
            if (midVal < target) {
                left = mid + 1;
            }
        }
        return res;
    }
}