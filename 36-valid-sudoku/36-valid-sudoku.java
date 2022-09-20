class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> checker = new HashSet<>(); //for storing the values seen
        //stored as string for easy hashing and to ensure uniqueness
        
        for(int row = 0; row<board.length; row++){
            
            for(int col = 0; col<board[row].length; col++) {
                char curr = board[row][col];
                if (curr == '.') continue;
                
                if (!checker.add(curr + "row" + col) || //checking the row
                    !checker.add(curr + "col" + row) || //checking the column
                    !checker.add(curr + "box" + col/3 + "-" + row/3)) //checking the box
                {
                    return false;
                }
            }
        }
        return true;
    }
}