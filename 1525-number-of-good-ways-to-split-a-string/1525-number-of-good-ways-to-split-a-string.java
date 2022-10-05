class Solution {
    public int numSplits(String s) {
        
        HashMap<Character, Integer> fMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        int goodSplits = 0;
        
        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        
        for (char lc : s.toCharArray()) {
            fMap.put(lc, fMap.getOrDefault(lc, 0) + 1);
            sMap.put(lc, sMap.getOrDefault(lc, 0) - 1);
            if (sMap.get(lc) <= 0) {
                sMap.remove(lc);
            }
            
            if (sMap.size() == fMap.size()) {
                goodSplits++;
            }
        }
        return goodSplits;
        
    }
}