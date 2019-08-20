class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        // Have a larger matrix cuz we want to avoid any boundary check
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxSquare = 0;
        
        for(int i = 1; i < dp.length ; i ++){
            for(int j = 1; j < dp[0].length; j ++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        
        return maxSquare * maxSquare;
    }
    
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}


// Optimal one!
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        // Have a larger matrix cuz we want to avoid any boundary check
        int[] dp = new int[matrix[0].length + 1];
        int maxSquare = 0;
        int prev = 0;
        
        for(int i = 1; i < matrix.length + 1 ; i ++){
            for(int j = 1; j < matrix[0].length + 1; j ++){
                int temp = dp[j];
                if(matrix[i - 1][j - 1] == '1'){
                    dp[j] = min(prev, dp[j - 1], dp[j]) + 1;
                    maxSquare = Math.max(maxSquare, dp[j]);
                }
                else{
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        
        return maxSquare * maxSquare;
    }
    
    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}