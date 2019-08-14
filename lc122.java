class Solution {
    public int maxProfit(int[] prices) {
        int A = 0;
        int B = Integer.MIN_VALUE;
            
        for(int price: prices){
            int prevA = A;
            int prevB = B;
            A = Math.max(prevA, prevB + price);
            B = Math.max(prevB, prevA - price);
        }        

        
        return A;
    }
}