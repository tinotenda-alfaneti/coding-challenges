class Solution {
    public int minSteps(String s, String t) {

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        int lettersDiff = 0;

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (char c : sMap.keySet()) {
            if (!tMap.containsKey(c)) {
                lettersDiff += sMap.get(c);
            }
            else {
                int lDiff = Math.abs(sMap.get(c) - tMap.get(c)); 
                lettersDiff += lDiff;
            }
        }
        for (char c : tMap.keySet()) {
            if (!sMap.containsKey(c)) {
                lettersDiff += tMap.get(c);
            }
        }

        return lettersDiff;


        
    }
}