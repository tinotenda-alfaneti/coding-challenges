/*
1. Check or store the frequency of each element in the array
2. use either a priority queue or sort according the frequency of the values
3. If the frequency is the same sort in decreasing order

Analysis
Runtime: Probably O(nlogn) since there is come sorting
Space : O(n) - since we are storing the elements
*/

class Solution {
 public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a,b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        int index = 0;
        int[] res = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : list) {
            
            int count = entry.getValue();
            int key = entry.getKey();
            
            for (int i=0; i<count; i++) {
                res[index++] = key;
            }
        }
        return res;
    }
}