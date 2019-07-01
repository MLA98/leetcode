class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grids = new int[m][n];
        grids[0][0] = 1;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(i - 1 >= 0){
                    grids[i][j] += grids[i - 1][j];
                }
                if(j - 1 >= 0){
                    grids[i][j] += grids[i][j - 1];
                }
            }
        }
        return grids[m - 1][n - 1];
    }
}
