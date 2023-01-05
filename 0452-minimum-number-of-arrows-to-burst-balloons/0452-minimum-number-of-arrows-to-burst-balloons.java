/*
Looks similar to the non-overlapping problem
The STEPS of my solution
1. Sorting the points
2. Count all distinct intervals and if there overlapping skip them
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (arr1, arr2) ->Integer.compare(arr1[1], arr2[1]));
        
        int arrows = 1; //for the first ballon
        
        int previousEnd = points[0][1];
        
        for (int[] currBalloon : points) {
            if (currBalloon[0] > previousEnd) {
                arrows++;
                previousEnd = currBalloon[1];
            }
        }
        
        return arrows;
        
    }
}