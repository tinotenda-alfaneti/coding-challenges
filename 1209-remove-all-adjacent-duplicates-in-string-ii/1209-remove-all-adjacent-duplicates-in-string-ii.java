class Solution {
    
    class Pair {
        int count;
        char letter;
        
        public Pair(char l, int c) {
            count = c;
            letter = l;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> pairStack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!pairStack.isEmpty() && pairStack.peek().letter == c) {
                pairStack.peek().count++;
            }
            else {
                pairStack.push(new Pair(c, 1));
            }
            if (pairStack.peek().count == k)
                pairStack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pairStack.isEmpty()) {
            Pair popped = pairStack.pop();
            int i = popped.count;
            while(i > 0) {
                sb.append(popped.letter);
                i--;
            }
        }
        
        
        
    
        return sb.reverse().toString();
    }
}