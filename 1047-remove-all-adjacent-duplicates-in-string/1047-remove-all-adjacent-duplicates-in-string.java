class Solution {
    public String removeDuplicates(String s) {
        
        int i = 0;
        char[] stack = s.toCharArray();
        
        for (int j = 0; j < s.length(); j++) {
            
            stack[i] = stack[j];
            if (i > 0 && stack[i - 1] == stack[i]) i -= 2;
            i++;
        }
        
        return new String(stack, 0, i);
    }
}