class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder strW1 = new StringBuilder();
        StringBuilder strW2 = new StringBuilder();
        
        for (String s : word1) {
            strW1.append(s);
        }
        
        for (String s : word2) {
            strW2.append(s);
        }
        
        return strW1.toString().equals(strW2.toString());
        
        
    }
}