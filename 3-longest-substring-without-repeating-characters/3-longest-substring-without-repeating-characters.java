class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length == 0 || length == 1) {
            return length;
        }

        Set<Character> charSet = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while(right < length && length - left > maxLength) {
            char c = s.charAt(right);
            if (!charSet.contains(c)) {
                charSet.add(c);
                maxLength = Math.max(maxLength, ++right - left);
            } else {
                charSet.remove(s.charAt(left++));
            }
        }

        return maxLength;
    }
}
