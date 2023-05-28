class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int lenS = s.length(), lenT = t.length();
        if(lenS < 1) return true;
        
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        
        int j=0;
        
        for (int i = 0; i < lenT; i++) {
            
            if (j < lenS && sArr[j] == tArr[i]) {
                j++;
            }
            
        }
        
        return j == lenS ? true : false; 
        
    }
}