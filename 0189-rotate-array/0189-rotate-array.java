
class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        if (k == n) return;
        
        int[] rotatedNums = new int[n];
        
        for (int i = 0; i < n; i++) {
            rotatedNums[i] = nums[i];
        }
        
        
        for (int i = 0; i < n; i++) {
            int index = (i + k)%n;
            nums[index] = rotatedNums[i]; 
        }
        
    }
}