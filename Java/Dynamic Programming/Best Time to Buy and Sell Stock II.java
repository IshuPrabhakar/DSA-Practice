class Solution {
    public int maxProfit(int[] prices) {
        
        int buyPrice = prices[0];
        int Profit = 0;
        
        // actually the question says we can perform as many transaction as we want
        
        for(int i = 1; i < prices.length ; i++){
            
            if(prices[i-1] < prices[i]){
                Profit += prices[i] - prices[i-1];
            }
        }
        
        return Profit;
    }
}
