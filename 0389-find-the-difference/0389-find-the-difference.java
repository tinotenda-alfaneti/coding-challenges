class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character, Integer> sMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c) || sMap.get(c) == 0) {
                return c;
            } else if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) - 1);
            }
        }
        
        return '-';
        
    }
}