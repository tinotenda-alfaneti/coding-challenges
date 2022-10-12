class Solution {
    public int maxProfit(int[] prices) {
        
        int buyingPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - buyingPrice;
            maxProfit = Math.max(currProfit, maxProfit);
            
            if (currProfit < 0) {
                buyingPrice = prices[i];
            }
        }
        
        return maxProfit;
        
        
    }
}

/*
Keep track of the minimum price, while also updating the max profit
*/