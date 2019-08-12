class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        if(grid[0][0] == 1 || grid[grid.length -1][grid[0].length - 1] == 1){
            return 0;
        }
        // Try to bug free 
        grid[0][0] = -1;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                pathAdder(i, j, grid);
            }
        }
        
        return - grid[grid.length - 1][grid[0].length - 1];
    }
    
    private void pathAdder(int i, int j, int[][] grid){
        if(grid[i][j] == 1){
            return;
        }
        if(i >= 1 && grid[i - 1][j] != 1){
            grid[i][j] += grid[i - 1][j];
        }
        
        if(j >= 1 && grid[i][j - 1] != 1){
            grid[i][j] += grid[i][j - 1];
        }
    }
}