/*
BACKTRACKING APPROACH

The base case:
    When we have exhausted all the open and the close we return
    and add the ans to the final array
Recursive call:
    1.
    When we still have the open brackets, we continue adding
    Otherwise, we remove the last added one
    2.
    While we still have the closing brackets,
    we continue adding the close
    Otherwise we remove the last that we just added
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backtrack(n, 0, 0, new StringBuilder(), answer);
        return answer;
    }
    
    public void backtrack(int n, int open, int close, StringBuilder curr, List<String> answer) {
        if (curr.length() == n*2) {
            answer.add(curr.toString());
            return;
        }
        if (open < n) {
            curr.append("(");
            backtrack(n, open + 1, close, curr, answer);
            curr.deleteCharAt(curr.length() - 1);
        }
        
        if (close < open) {
            curr.append(")");
            backtrack(n, open, close + 1, curr, answer);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}