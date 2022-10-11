class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prodArray = new int[nums.length];
        int[] leftPass = new int[nums.length];
        int[] rightPass = new int[nums.length];
        Arrays.fill(leftPass, 1);
        Arrays.fill(rightPass, 1);
        
        for (int i = 1; i < nums.length; i++) {
            leftPass[i] = leftPass[i - 1] * nums[i - 1];
        }
        
        for (int i = nums.length - 2; i >= 0; i--) {
            rightPass[i] = rightPass[i + 1] * nums[i + 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            prodArray[i] = leftPass[i] * rightPass[i];
        }
        
        return prodArray;
        
        
    }
}
/*
[3,2,3,4]
     ^
       
[1,1,1,1]
 ^


[3,6,18,1]
      ^
*/