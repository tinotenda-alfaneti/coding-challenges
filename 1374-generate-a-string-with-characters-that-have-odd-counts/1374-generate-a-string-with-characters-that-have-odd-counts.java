class Solution {
    public String generateTheString(int n) {
        
        char[] charArr = new char[n];
        
        for (int i = 0; i < n; i++) {
            charArr[i] = 'x';
        }
        
        if (n % 2 == 0)
            charArr[n - 1] = 'b';
        
        return String.valueOf(charArr);
        
    }
}