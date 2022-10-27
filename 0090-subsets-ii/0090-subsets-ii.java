class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> allSubsets = new ArrayList<>();
        Set<ArrayList<Integer>> lookUp = new HashSet<>();
        int n = nums.length;
        
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                if(((i >> j) & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            Collections.sort(subset);
            if(!lookUp.contains(subset)) {
                allSubsets.add(subset);
                lookUp.add(subset);
            }
        }
        
        return allSubsets;
        
    }
}