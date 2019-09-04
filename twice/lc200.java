class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; 
        
        if(grid.length == 0){
            return 0;
        }
                
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    spawn(grid, i, j);
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    private void spawn(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length 
           || j < 0 || j >= grid[0].length 
          || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        spawn(grid, i + 1, j);
        spawn(grid, i - 1, j);
        spawn(grid, i, j + 1);
        spawn(grid, i, j - 1);
    }
}