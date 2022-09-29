
class Solution {
    public boolean isPalindrome(String s) {
        
        if (s.length() == 0 || s.length() == 1) return true;
        
        ArrayList<Character> sArray = new ArrayList<>();
        ArrayList<Character> revArray = new ArrayList<>();
        
        
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                char l = Character.toLowerCase(c);
                sArray.add(l);
                revArray.add(0, l);
            }
        }
        // if (revArray.size() == 1) return false;
        // else{
        //     return sArray.equals(revArray);
        // }
        return sArray.equals(revArray);
    }
}