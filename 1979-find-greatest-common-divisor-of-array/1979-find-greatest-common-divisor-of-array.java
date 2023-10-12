class Solution {
    public int findGCD(int[] nums) {
        
        int max = -2000;
        int min = 2000;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        
        return getGCD(max, min);
        
    }
    
    public int getGCD(int n, int m) {
        if (m == 0) return n;
        return getGCD(m, n % m);
    }
}