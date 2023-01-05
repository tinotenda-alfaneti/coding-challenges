/*
For interval problems, 
1. Sort the intervals either according to start value or to end
2. Then compare the  intervals - take note of the edge cases like if intervals that start at the same number are considered overlapping

That is basically all about intervals.
Since there is some sorting, the runtime will be O(nlog n)
In this question the space complexity is O(1)
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        } );

        int previousEnd = intervals[0][1];
        int numOfRemoved = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= previousEnd) {
                previousEnd = intervals[i][1];
            } else {
                previousEnd = Math.min(intervals[i][1], previousEnd);
                numOfRemoved++;
            }
        }
        
        return numOfRemoved;
    }
}