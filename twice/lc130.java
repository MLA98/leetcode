class Solution {
    public void solve(char[][] board) {
         if (board.length == 0 || board[0].length == 0){
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i ++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }
            if(board[i][n - 1] == 'O'){
                dfs(i, n - 1, board);
            }
        }
        
        for(int i = 0; i < n; i ++){
            if(board[0][i] == 'O'){
                dfs(0, i, board);
            }
            if(board[m - 1][i] == 'O'){
                dfs(m - 1, i, board);
            }
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int i, int j, char[][] board){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        
        if(board[i][j] == 'O'){
            board[i][j] = '*';
            dfs(i, j + 1, board);
            dfs(i, j - 1, board);
            dfs(i - 1, j, board);
            dfs(i + 1, j, board);
        }
    }
}