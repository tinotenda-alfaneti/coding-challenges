class Solution {
    public int myAtoi(String s) {
        
        int res = 0;
        
        boolean positive = true;
        
        int len = s.trim().toCharArray().length;
        
        for (int i = 0; i < len; i++) {
            
            char c = s.trim().charAt(i);
                
            if (c == '-' && i == 0)
                positive = false;
            else if (c == '+' && i == 0)
                positive = true;
            else if (c - '0' < 10 && c - '0' >= 0) {
                
                if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < c - '0')
                    return positive == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                
                res = (res * 10) + (c - '0');
                
            }
            else
                break;
        }
        
        res = positive == true ? res : -1 * res;
        
        return res;
        
    }
}