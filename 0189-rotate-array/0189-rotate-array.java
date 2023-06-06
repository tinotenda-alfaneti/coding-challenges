
class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        k = k%n;
        
        if (k == n) return;
        
        reverseArr(nums, 0, n-1);
        reverseArr(nums, 0, k-1);
        reverseArr(nums, k, n-1);
          
    }
    
    public void reverseArr(int[] numsArr, int start, int end) {
        
        while(start < end) {
            int removed = numsArr[start];
            numsArr[start] = numsArr[end];
            numsArr[end] = removed;
            end--;
            start++;
        }
        
    }
}