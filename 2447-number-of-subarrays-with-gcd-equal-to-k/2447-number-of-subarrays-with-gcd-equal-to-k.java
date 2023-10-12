class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int finalRes = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int currGCD = nums[i];
            if (currGCD == k) finalRes++;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < k) break;
                currGCD = calculateGCD(nums[j], currGCD);
                if (currGCD == k) finalRes++;
            }
            
        }
        
        return finalRes;
        
    }
    
    public int calculateGCD(int n, int m) {
        if (m == 0) return n;
        return calculateGCD(m, n % m);
    }
}