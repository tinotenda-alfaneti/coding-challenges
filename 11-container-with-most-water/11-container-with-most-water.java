/**
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

//Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.
example : heights = [1,8,6,2,5,4,8,3,7] ->  49
[2, 8] => 2
[1,4,2,1,1] => 

 [1,8,6,2,5,4,8,3,7]
  ^ ^
  
*/





class Solution {
    public int maxArea(int[] height) {
        
        if (height.length <= 1) {
            return 0;
        }
    
        
        int L = 0, R = height.length - 1;
        int maxVol = Integer.MIN_VALUE;
        
        while (L < R) {
            int currVol = Math.min(height[L], height[R]) * (R - L);
            maxVol = Math.max(maxVol, currVol);
            if (height[R] >= height[L]) L++;
            else R--;
        }
        return maxVol;
        
    }
}