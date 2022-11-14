class FindSumPairs {
    
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> nums2Map = new HashMap<>();
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        for (int num : nums2) {
            nums2Map.put(num, nums2Map.getOrDefault(num, 0) + 1);
        }
        
    }
    
    public void add(int index, int val) {
        
        nums2Map.put(nums2[index], nums2Map.getOrDefault(nums2[index], 0) - 1);
        nums2[index] += val;
        nums2Map.put(nums2[index], nums2Map.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        
        
        int count = 0;
        
        for (int n : nums1) {
            
            count += nums2Map.getOrDefault(tot - n, 0);
            
        }
        return count;
        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */