/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;

        int b = 0;
        int s = 1;

        int maxSoFar = 0;

        while (s < n) {
            if (prices[b] < prices[s]) {
                int tmpProf = prices[s] - prices[b];
                maxSoFar = Math.max(tmpProf, maxSoFar);
            } else {
                b = s;
            }
            s++;
        }
        return maxSoFar;

        
    }
}
// @lc code=end

