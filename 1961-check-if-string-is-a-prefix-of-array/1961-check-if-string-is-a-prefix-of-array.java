class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        
        String newS = "";
        
        for (String word : words) {
            newS += word;
            if (s.equals(newS))
                return true;
            if (s.indexOf(newS) == -1)
                return false;
        }
        
        return false;
    }
}