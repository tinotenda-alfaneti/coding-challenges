class Solution {
    public int reverse(int x) {
        int res = 0, digit = 0;
        while (x!=0){
            //getting the last digit of the number
            digit = x%10;
            // multiplying the current res by 10 then adding the new number
            // checking if the number does not exceed the maximum integer value
            if (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && digit > 7) return 0;
            if (res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && digit > 7) return 0;
            res = (res*10) + digit;
            // integer division of the number
            x /= 10;
        
        }
        return res;   
    }
}