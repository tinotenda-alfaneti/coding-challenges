/*
input - Array of integers
-------------------------
Output - Array with k most frequent


Approach
Get the frequency of each number in the array - considering a hashmap
Order the elements according to the frequency - 
Return the last/first k elements in an array


It turns out we have a better solution that can give us a runtime of 0(n), it is nothing other than the bucket sort

So basically the algorithm works by storing the number of times each element occurs
After doing that, we only need to return the first k non null values from the left

Do you get it?


*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[len + 1];
        int[] result = new int[k];
        
        //Get frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        //Order elements according to frequency
        for (Map.Entry<Integer, Integer> keyVal : freqMap.entrySet()) {
            int index = keyVal.getValue();
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(keyVal.getKey());
        }
        
        
        // Get the k most frequent elements
        for (int i = len; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                for(int num : bucket[i]) {
                    result[k-1] = num;
                    k--;
                }
                
            }
        }
        
        return result;
        
        
    }
}