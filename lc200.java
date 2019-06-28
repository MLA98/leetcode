// You just think of a great algo but you ruined it:) 
// Proof read in future please as in the intervie, the error is not good at all.
class Solution {
    public int numIslands(char[][] grid) {
        // Some tricks may help saving space or runtime;
        // Simply change the ones to 0;
        int ans = 0;
        for(int i = 0; i < grid.length; i ++){ 
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == '1'){
                    expand(grid, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }
    
    private void expand(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        else{
            grid[i][j] = '0';
        }
        
        expand(grid, i, j - 1);
        expand(grid, i, j + 1);
        expand(grid, i - 1, j);
        expand(grid, i + 1, j);
        return;
    }
}