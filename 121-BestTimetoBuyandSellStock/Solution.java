class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        
        int profit = 0;
        
        // two iteration solution, time limitation exceed
        /*
        for(int i = 0; i < prices.length - 1; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        */
        
        int buyIdx = 0;
        int sellIdx = 1;
        while(sellIdx < prices.length) {
            if(prices[buyIdx] > prices[sellIdx]) {
                buyIdx = sellIdx;
            } else {
                int t = prices[sellIdx] - prices[buyIdx];
                if(t > profit) {
                    profit = t;
                }
            }
            
            sellIdx++;
        }
        
        return profit;
    }
}
