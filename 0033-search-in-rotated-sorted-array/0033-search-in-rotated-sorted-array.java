/**
Brute Force Approach
Just doing Linear Search
Runtime: O(n)
Space: O(1)

Optimalizing

FInd a way to do binary search on the two halves.

input = [4,5,6,7,0,1,2]
               ^
start = 4, last = 2
l and r 
mid = 7
target is less than start hence go left
start 0, last = 2

 */

class Solution {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while( L <= R) {
            int mid = (L+R)/2;

            if(nums[mid] == target)
                return mid;
            
            //Check if the left array is good
            else if (nums[L] <= nums[mid]){
                if (target < nums[mid] && nums[L] <= target){
                    R = mid - 1;
                }
                else{
                    L = mid + 1;
                }
            } else{
                if (target > nums[mid] && nums[R] >= target){
                    L = mid + 1;
                }else{
                    R = mid - 1;
                }
            } 

        }

        return -1;
        
    }
}