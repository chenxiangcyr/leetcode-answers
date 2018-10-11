class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        
        // null pointer check
        if(prices == null) {
            return profit;
        }
        
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                profit = profit + (prices[i + 1] - prices[i]);
            }
        }
        
        return profit;
    }
}
