/*
"abcc" - true - remove only 'c' and frequency becomes the same
"aaxxbbz" - false - removing an letter will make the frequency different
"aabbbb" - false
# removing only one letter
# Keep track of the minimum in an array and subtract it from the hashmap.
If there is only one element with a count of 1 return true
*/


class Solution {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        HashSet<Integer> counts = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        for (char c : freq.keySet()) {
            freq.put(c, freq.get(c) - 1);
            counts = new HashSet<>();
            for(int i : freq.values()) {
                if (i > 0) {
                    counts.add(i);
                }
            }
            if (counts.size() == 1) return true;
            freq.put(c, freq.get(c) + 1);
            
        }
        return false;
    }
}