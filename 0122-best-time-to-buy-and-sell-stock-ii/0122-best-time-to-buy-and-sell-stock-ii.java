class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = prices[0];
        int totalProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            
            int profit = prices[i] - buy;
            
            if (profit >= 0) {
                totalProfit += profit;
            }
            
            buy = prices[i];
             
        }
        return totalProfit;
        
    }
}