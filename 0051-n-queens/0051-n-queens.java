/*
Backtracking can work here
I need to store the columns, the positive diagonals and negative diagonals
After that I perform backtracking c
*/
class Solution {
    
        
    public List<List<String>> solveNQueens(int n) {
        
        String[][] board = new String[n][n];
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> negDiags = new HashSet<>();
        HashSet<Integer> posDiags = new HashSet<>();
        
        List<List<String>> result = new ArrayList<>();
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ".";
            }
        }
        
        backtrack(0, cols, negDiags, posDiags, board, result);
        return result;
        
        
    }
    
    public void backtrack(int row, HashSet<Integer> cols,
                          HashSet<Integer> negDiags, 
                          HashSet<Integer> posDiags,
                          String[][] board, 
                          List<List<String>> result) {
        if (row == board.length) {
            ArrayList<String> sol = new ArrayList<>();
            for (String[] solRow : board) {
                sol.add(String.join("", solRow));
            }
            
            result.add(sol);
            return;
        }
        
        for (int col = 0; col < board.length; col++) {
            if (cols.contains(col) || 
                negDiags.contains(row - col) || 
                posDiags.contains(row + col)) {
                continue;
            }
            
            cols.add(col);
            negDiags.add(row - col);
            posDiags.add(row + col);
            board[row][col] = "Q";
            
            backtrack(row + 1, cols, negDiags, posDiags, board, result);
            
            cols.remove(col);
            negDiags.remove(row - col);
            posDiags.remove(row + col);
            board[row][col] = ".";
            
        }
    }
}