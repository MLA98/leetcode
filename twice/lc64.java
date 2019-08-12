class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int j = 1; j < n; j ++){
            grid[0][j] += grid[0][j - 1];
        }
        for(int i = 1; i < m; i ++){
            for(int j = 0; j < n; j ++){
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i - 1 >= 0){
                    up = grid[i - 1][j];
                }
                if(j - 1 >= 0){
                    left = grid[i][j - 1];
                }
                grid[i][j] += Math.min(up, left);
            }
        }
        return grid[m - 1][n - 1];
    }
}