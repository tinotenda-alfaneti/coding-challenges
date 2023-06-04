
class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        int majCount = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++) {     
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1); 
        }
        
        for (int key : counts.keySet()) {
            if (counts.get(key) > majCount) return key;
        }
        
        return 0;  
        
    }
}