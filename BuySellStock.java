class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int totalProfit = 0;
        int currentProfit = 0;
        
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            
            currentProfit = prices[i] - min;
            
            if (currentProfit > totalProfit) {
                totalProfit = currentProfit;
            }
        }
        
        return totalProfit;
    }
}
