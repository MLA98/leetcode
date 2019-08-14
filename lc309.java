// O(n) O(1) soln
class Solution {
    public int maxProfit(int[] prices) {
        int B = 0;
        int C = 0;
        int A = Integer.MIN_VALUE;
        
        
        for(int i = 0; i < prices.length; i ++){
            int prevA = A;
            int prevB = B;
            int prevC = C;
            A = Math.max(prevA, prevC - prices[i]);
            B = prices[i] + prevA;
            C = Math.max(prevB, prevC);
        }
        
        return Math.max(Math.max(A,B), C);
    }
}

// O(n) O(n) soln
class Solution {
    public int maxProfit(int[] prices) {
        int[] A = new int[prices.length + 1];
        int[] B = new int[prices.length + 1];
        int[] C = new int[prices.length + 1];
        A[0] = Integer.MIN_VALUE;
        
        
        for(int i = 0; i < prices.length; i ++){
            int index = i + 1;
            A[index] = Math.max(A[index - 1],
                                  C[index - 1] - prices[i]);
            B[index] = prices[i] + A[index - 1];
            C[index] = Math.max(B[index - 1],
                                  C[index - 1]);
        }
        
        return Math.max(Math.max(A[prices.length], B[prices.length]), C[prices.length]);
    }
}