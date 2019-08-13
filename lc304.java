// Row cache;
// preCompute time: O(mn);
// fetchtime: O(m);
// space: O(mn);

private int[][] dp;

public NumMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return;
    dp = new int[matrix.length][matrix[0].length + 1];
    for (int r = 0; r < matrix.length; r++) {
        for (int c = 0; c < matrix[0].length; c++) {
            dp[r][c + 1] = dp[r][c] + matrix[r][c];
        }
    }
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    int sum = 0;
    for (int row = row1; row <= row2; row++) {
        sum += dp[row][col2 + 1] - dp[row][col1];
    }
    return sum;
}

// Optimal
// pre: O(mn)
// fetch: O(1)
// space: O(mn)
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return ;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] - dp[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] 
            - dp[row2 + 1][col1] + dp[row1][col1];
    }
}


// Brute force
class NumMatrix {
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        for(int i = row1; i <= row2; i ++){
            for(int j = col1; j <= col2; j ++){
                sum += matrix[i][j];
            }
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */


 // sb cache
class NumMatrix {
    Map<String, Integer> map;

    public NumMatrix(int[][] matrix) {
        map = new HashMap<>();
        int m = matrix.length;
        int n = 0;
        if(m > 0)
             n = matrix[0].length;
        
        if(m > 0 && n > 0)
            for(int row1 = 0; row1 < m; row1 ++){
                for(int row2 = row1 + 1; row2 < m; row2 ++){
                    for(int col1 = 0; col1 < n; col1 ++){
                        for(int col2 = col1 + 1; col2 < n; col2 ++){

                            int sum = 0;

                            for(int i = row1; i <= row2; i ++){
                                for(int j = col1; j <= col2; j ++){
                                    sum += matrix[i][j];
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(row1);
                            sb.append('-');
                            sb.append(row2);
                            sb.append('-');
                            sb.append(col1);
                            sb.append('-');
                            sb.append(col2);
                            map.put(sb.toString(), sum);
                        }
                    }
                }
            }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        StringBuilder sb = new StringBuilder();
                        sb.append(row1);
                        sb.append('-');
                        sb.append(row2);
                        sb.append('-');
                        sb.append(col1);
                        sb.append('-');
                        sb.append(col2);
        
        return map.get(sb.toString());
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */