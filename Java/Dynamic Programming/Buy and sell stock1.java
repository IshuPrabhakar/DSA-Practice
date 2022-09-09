class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = prices[0];
        int maxProfit = 0;
        
        // this for finding the minimum value at which we can buy stocks
        for(int i = 0; i < prices.length - 1; i++){
            buyPrice = Integer.min(buyPrice, prices[i]);
            
            maxProfit = Integer.max(maxProfit, prices[i+1] - buyPrice);
        }
        maxProfit = Integer.max(maxProfit, prices[prices.length - 1] - buyPrice);
        
        return maxProfit;
    }
}
