class Solution {
    public double myPow(double x, int n) {
        
        if (n < 0) {
            double result = recursePow(x, -1*n);
            return 1/result;
        }
        double result = recursePow(x, n);
        return result;
        
    }
    
    public double recursePow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        double result = recursePow(x * x, n/2);  
        return n % 2 == 0 ? result : x * result;
    }
}