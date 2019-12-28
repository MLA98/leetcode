class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        
        int bot = 0;
        int top = 0;
        int max = 0;
        
        int i = 0;
        
        // We dont care about the last number as:
        // If it is a valley, we just dont have any time to buy it and sell
        // If it is a peak, we already 
        
        // Actually we care about the last number, but it is taken cared by 
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i ++;
            }
            
            bot = prices[i];
            
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i ++;
            }
            
            top = prices[i];
            
            max += top - bot;
        }
        
        return max;
    }
}