class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = 0;
        
        String[] sWords = s.split(" ");
        
        for(char c : sWords[sWords.length - 1].toCharArray()) {
            len++;
        }
        
        return len;
        
    }
}