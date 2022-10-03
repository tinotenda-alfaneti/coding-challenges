class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long res = 0;
        
        int last = 0;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] - last <= 1) {
                last = nums[i];
            }
            else {
                int gap = nums[i] - last - 1; // since it is an exclusive range
                if (k >= gap) {
                    int n = gap;
                    //formula for calculating sum of numbers upto n
                    res += ((n * (2L * (last + 1) + (n - 1)))/2);
                    last = nums[i];
                    k -= gap;
                } 
                else {
                    int n = k;
                    res += ((n * (2L * (last + 1) + (n - 1)))/2);
                    last += k;
                    k = 0;
                }
            }
            if (k == 0) break;
        }
        //taking care of the remaining k 
        int n = k;
        res += ((n * (2L * (last + 1) + (n - 1)))/2);
        return res;
        
    }
}