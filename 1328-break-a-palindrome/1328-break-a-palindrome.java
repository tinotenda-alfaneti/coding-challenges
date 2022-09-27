class Solution {
    public String breakPalindrome(String palindrome) {
        
        char[] characters = palindrome.toCharArray();
        int len = palindrome.length();
        
        for (int i = 0; i < len / 2; i++) {
            if (characters[i] != 'a') {
                characters[i] = 'a';
                return String.valueOf(characters);
            }
        }
        characters[len - 1] = 'b';
        return len <= 1 ? "" : String.valueOf(characters);
        
    }
}