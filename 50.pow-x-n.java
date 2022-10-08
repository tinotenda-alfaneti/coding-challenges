/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        double prod;
        prod = helper(x, (-1*n));
        
        if (n<0) {
            return (1/prod);
        }
        return prod;
            
    }
    static double helper(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        double prod = helper(x, n/2);
        prod *= prod;
        if (n%2 != 0) return x*prod;
        return prod;
    }
}
// @lc code=end

