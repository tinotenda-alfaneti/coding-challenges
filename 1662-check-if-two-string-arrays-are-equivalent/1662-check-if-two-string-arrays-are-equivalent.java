class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder strW1 = new StringBuilder();
        StringBuilder strW2 = new StringBuilder();
        
        for (String s : word1) {
            for(char c : s.toCharArray()) {
                strW1.append(c);
            }
        }
        
        for (String s : word2) {
            for(char c : s.toCharArray()) {
                strW2.append(c);
            }
        }
        
        return strW1.toString().equals(strW2.toString());
        
        
    }
}