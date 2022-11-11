class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 1)
            return "";
        
        int first = 0;
        int last = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i+1);
            
            int len = Math.max(len1, len2);
            if (len > last - first) {
                first = i - ((len - 1)/2);
                last = i + (len/2);
            }
        }
        return s.substring(first, last + 1);
    }
    
    public int checkPalindrome(String s, int L, int R) {
        if (L > R && s == null)
            return 0;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1; 
    }
}