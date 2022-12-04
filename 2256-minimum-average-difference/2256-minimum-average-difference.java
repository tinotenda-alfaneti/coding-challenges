/*
Do the first pass through the array from the left,
Store the sum of the previous element 
Do the same thing coming from the right an store in a different array

After that loop through the first array
Take the element at the corresponding index and divided by length minus current index

It turns out we can optimize on the space by getting rid of the prefix and sufix array so that we can only have a variable currPrefix, totalSum 
The total sum - currPrefix gives us the right sum
That's all we need
*/
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        long currPrefixSum = 0;
        
        // Get total sum of array.
        long totalSum = 0;
        for (int index = 0; index < n; ++index) {
            totalSum += nums[index];
        }
        
        for (int index = 0; index < n; ++index) {
            currPrefixSum += nums[index];
            
            // Calculate average of left part of array, index 0 to i.
            long leftPartAverage = currPrefixSum / (index + 1);
            
            // Calculate average of right part of array, index i+1 to n-1.
            long rightPartAverage = 0;
            // If right part have 0 elements, then we don't divide by 0.
            if (index != n - 1) {
                rightPartAverage = (totalSum - currPrefixSum) / (n - index - 1);
            }
            
            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            // If current difference of averages is smaller,
            // then current index can be our answer.
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        
        return ans;
    }
}