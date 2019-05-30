class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] maxSquare = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 1; i < maxSquare.length; i ++){
            for (int j = 1; j < maxSquare[0].length; j ++){
                if (matrix[i - 1][j - 1] == '1'){
                    maxSquare[i][j] = Math.min(Math.min(maxSquare[i - 1][j],
                                              maxSquare[i][j - 1]),
                                              maxSquare[i - 1][j - 1]) + 1;
                    max = Math.max(maxSquare[i][j], max);
                }
            }
        }
        return max * max;
    }
    
}

// Cuz its tag is DP. I thought of a DP solution. However, it does not work because of its complexit.
// The solution is beutifual. It is quite similiar to mine, but I messed up the direction. 
