class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }
}
