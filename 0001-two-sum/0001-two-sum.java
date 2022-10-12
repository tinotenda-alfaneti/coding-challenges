class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        //target = num1 + num2 => num2 = target - num1
        HashMap<Integer, Integer> complMap = new HashMap<>();
        int[] resultArr = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            int compl = target  - nums[i];
            complMap.put(compl, i);
        }
        
        for (int j = 0; j < nums.length; j++) {
            int key = nums[j];
            if (complMap.containsKey(key) && complMap.get(key) != j) {
                resultArr[0] = Math.min(complMap.get(key), j);
                resultArr[1] = Math.max(complMap.get(key), j);
                break;
            }
        }
        return resultArr;        
    }
}