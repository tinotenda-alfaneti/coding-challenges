class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        
        double L = 0;
        double R = x;
        
        while (L <= R) {
            double mid = (L + R) /2.0;
            long midSq = (long) (mid * mid);
            
            if (midSq == x) return (int) mid;
            else if (midSq > x) R = mid;
            else L = mid;
        }
        return (int) L;
    }
}