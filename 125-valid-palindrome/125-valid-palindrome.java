
class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.length() == 0 || s.length() == 1) return true;
        
        return checkPalindrome(s.toLowerCase(), 0, s.length() - 1);
    }
    
    public boolean checkPalindrome(String s, int l, int r) {
        if (s == null || l < 0 || r < 0) return true;
        if (l >= r) return true;
        if (!(Character.isLetter(s.charAt(l)) || Character.isDigit(s.charAt(l))))
            return checkPalindrome(s, l + 1, r);
        if (!(Character.isLetter(s.charAt(r)) || Character.isDigit(s.charAt(r)))) {
            return checkPalindrome(s, l, r - 1);}
        if (s.charAt(l) == s.charAt(r))
            return checkPalindrome(s, l + 1, r - 1);
        return false;
    }
}