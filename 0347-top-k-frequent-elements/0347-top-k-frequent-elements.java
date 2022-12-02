/*
input - Array of integers
-------------------------
Output - Array with k most frequent


Approach
Get the frequency of each number in the array - considering a hashmap
Order the elements according to the frequency - 
Return the last/first k elements in an array


*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> freqArr = new ArrayList<>();
        HashSet<Integer> kSet = new HashSet<>();
        int[] result = new int[k];
        
        //Get frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        //Order elements according to frequency
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freqArr.add(entry.getValue());
        }
        
        Collections.sort(freqArr);
        int index = freqArr.size() - 1;
        for (int i = index; k > 0; i--) {
            kSet.add(freqArr.get(i));
            k--;
        }
        
        // Get the k most frequent elements
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (kSet.contains(entry.getValue())) {
                result[k] = entry.getKey();
                k++;
            }
        }
        
        return result;
        
        
    }
}