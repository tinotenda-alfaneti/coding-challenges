/*
Build the permutations recursively
- Have a set to store the elements you have visited before,
- Store the single build arraylists 
- Add the elements to the result if the length of set is equal to length of the array
- return
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> permRes = new ArrayList<>();
        List<Integer> partialRes = new ArrayList<Integer>();
        HashSet<Integer> used = new HashSet<Integer>();
        
        perfomPermutation(nums, partialRes, used, permRes);
        return permRes;
        
        
    }
    
    public void perfomPermutation(int[] nums, List<Integer> partialRes, HashSet<Integer> used, List<List<Integer>> permRes) {
        
        if (nums.length == used.size()) {
            permRes.add(List.copyOf(partialRes));
            return;
        }
    
        for(int i = 0; i < nums.length; i++) {
            if (!(used.contains(nums[i]))) {
                partialRes.add(nums[i]);
                used.add(nums[i]);
                perfomPermutation(nums, partialRes, used, permRes);
                partialRes.remove(partialRes.indexOf(nums[i]));
                used.remove(nums[i]);
            }
        }
        
    }
}