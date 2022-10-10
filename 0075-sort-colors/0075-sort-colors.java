/*

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of 
the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

[1,0,2,1] => 
{1: 2, 0:1, 2:1}
i = 2

[0,1,1,2]
     
Input: nums = [2,0,2,1,1,0]

Output: [0,0,1,1,2,2]

*/


class Solution {
    
    
    public void sortColors(int[] nums) {
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        for (int i = 0; i < nums.length; i++){
            if (i + 1 <= freqMap.getOrDefault(0, 0)){
                nums[i] = 0;
            }
            else if (i + 1 <= freqMap.getOrDefault(1, 0) + freqMap.getOrDefault(0, 0)){
                nums[i] = 1;
            }
            else if (i + 1 <= freqMap.getOrDefault(2, 0) + freqMap.getOrDefault(1, 0) + freqMap.getOrDefault(0, 0)){
                nums[i] = 2;
            }
        }

    }
}