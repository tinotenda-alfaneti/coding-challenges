class Solution {
    public String removeStars(String s) {
        int i = 0;
        int n = s.length();
        char[] stack = s.toCharArray();
        
        for (int j = 0; j < n; j++) {
            if (stack[j] == '*') {
                i -= 1;
            } else {
                stack[i] = stack[j];
                i++;
            }
        }
        return new String(stack, 0, i);
    }
}