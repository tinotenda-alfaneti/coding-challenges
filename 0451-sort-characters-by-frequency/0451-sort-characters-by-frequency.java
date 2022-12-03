/*
BucketSort Algorithm from last question is idea here

STEP 1: Get all the frequencies
STEP 2: Place each key in the map to a index that corresponds to its index in the bucket, the array
STEP 3: Then after that, loop through the bucket from the end, placing the elements to a string buffer 
*/
class Solution {
    public String frequencySort(String s) {
        
        List<Character>[] bucket = new List[s.length() + 1];
        HashMap<Character, Integer> freqMap = new HashMap<>();
        StringBuffer strBuff = new StringBuffer();
        
        //Getting the frequencies
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        //Adding the characters to the bucket
        for (char c : freqMap.keySet()) {
            int i = freqMap.get(c);
            if (bucket[i] == null) {
                bucket[i] = new ArrayList<>();
            }
            bucket[i].add(c);
        }
        
        //Creating a string taking the characters from the right
        for (int i = bucket.length - 1; i > 0; i--) {
            if (bucket[i] != null) {
                int freq = i;
                for (char ch : bucket[i]) {
                    for (int j = 0; j < freq; j++) {
                        strBuff.append(ch);
                    }
                }
                    
            }
        }
        return strBuff.toString();
        
        
        
    }
}