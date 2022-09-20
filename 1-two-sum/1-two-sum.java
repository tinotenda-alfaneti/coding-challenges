class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> collection = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        for (int i = 0; i<nums.length; i++) {
            int a = target - nums[i]; // target = 
            if (collection.containsKey(a)) {
                res[0] = collection.get(a);
                res[1] = i;
                return res;
            } else {
                collection.put(nums[i], i);
            }
        }
        return res;
    }
}