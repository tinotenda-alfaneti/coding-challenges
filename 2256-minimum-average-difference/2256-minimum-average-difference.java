/*
Do the first pass through the array from the left,
Store the sum of the previous element 
Do the same thing coming from the right an store in a different array

After that loop through the first array
Take the element at the corresponding index and divided by length minus current index
*/
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int len = nums.length;
        long[] leftPass = new long[len];
        long[] rightPass = new long[len];
        if (len == 1) return 0;
        
        leftPass[0] = nums[0];
        for(int i = 1; i < len; i++) {
            long res = leftPass[i - 1] + nums[i];
            leftPass[i] = res;
        }
      
        rightPass[len - 1] = 0;
        for(int i = len - 1; i > 0; i--) {
            long res = rightPass[i] + nums[i];
            rightPass[i - 1] = res;
        }
        
        long minSoFar = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < len; i++) {
            
            long avgDiff = len - (i + 1) != 0 ? Math.abs((leftPass[i]/(i+1)) - (rightPass[i]/(len - (i + 1)))) : (leftPass[i]/(i+1));
            if (minSoFar > avgDiff) {
                minSoFar = avgDiff;
                minIndex = i;
            }
        }
        return minIndex;
    }
}