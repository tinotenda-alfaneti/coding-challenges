class Solution {
    public String removeDuplicateLetters(String s) {
        
        HashMap <Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        
        // check the last occurrence of a character in the string
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        
        // a stack to make it easy to track the previous character
        Stack<Character> stack = new Stack<>();
        
        // loop through the string and check if the character is not in stack and is less that 
        // the characters already in the stack and it is not the last index
        // then pop it else push to the stack
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.contains(c)){
                while (!stack.isEmpty() && (stack.peek() - 'a') > (c - 'a') && i < map.get(stack.peek()))
                    stack.pop();
                stack.push(c);
            }
            
            
        }
        
        // reversing the string
        while(!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        
        return ans.toString();
        
    }
}