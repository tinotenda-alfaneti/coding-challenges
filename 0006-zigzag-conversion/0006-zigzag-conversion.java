/*
The idea is knowing which row to populate.
To do that keep track of the current row and whether you are moving up or down

*/

class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
        String res = "";
        
        int len =  Math.min(numRows, s.length());
        
        String[] resArr = new String[len];
        
        for (int i = 0; i < len; i++) {
            resArr[i] = "";
        }
        
        boolean moveDown = false;
        
        int currRow = 0;
        
        for(char c : s.toCharArray()) {
            if (currRow == 0 || (currRow + 1)%numRows == 0) {
                moveDown = !moveDown;
            }
            
            resArr[currRow] = resArr[currRow] + c;
            currRow = moveDown ? currRow + 1 : currRow - 1;
            
        }
        
        for(String rowS : resArr) {
            res += rowS;
        }
        
        return res;
        
    }
    
}