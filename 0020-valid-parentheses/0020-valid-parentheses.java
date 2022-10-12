class Solution {
    public boolean isValid(String s) {
        
        // to have a stack to store the opening brackets
        // if we encounter a closing bracket, we check with the peek in the stack
        // if they match, we pop the one in the stack, else we return false
        
        Stack<Character> bracStack = new Stack<>();
        
        HashSet<Character> openColSet = new HashSet<>();
        openColSet.add('(');
        openColSet.add('{');
        openColSet.add('[');
        
        if (!openColSet.contains(s.charAt(0))) return false;
        
        for (Character c : s.toCharArray()) {
            if (openColSet.contains(c)) {
                bracStack.push(c);
            }
            else {
                if (bracStack.isEmpty()) return false;
                else if (c == ')' && bracStack.peek() == '(')
                    bracStack.pop();
                else if (c == ']' && bracStack.peek() == '[')
                    bracStack.pop();
                else if (c == '}' && bracStack.peek() == '{')
                    bracStack.pop();
                else
                    return false;
            }
        }
        if (bracStack.size() == 0)
            return true;
        else
            return false;
    }
}