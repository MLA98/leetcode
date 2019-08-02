// time: O(1) + space: O(n)
class TicTacToe {

    /** Initialize your data structure here. */
    private int diagonal = 0;
    private int antidiagonal = 0;
    private int[] cols;
    private int[] rows;
    private int n;
    public TicTacToe(int n) {
        this.cols = new int[n];
        this.rows = new int[n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1? -1: 1;
        
        if(col == row){
            diagonal += toAdd;
        }
        
        if(n - col - 1 == row){
            antidiagonal += toAdd;
        }
        
        cols[col] += toAdd;
        rows[row] += toAdd;
        
        if(Math.abs(cols[col]) == n || Math.abs(rows[row]) == n
          || Math.abs(antidiagonal) == n || Math.abs(diagonal) == n){
            return player;
        }
            
            
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */




// O(n) time, O(n^2) space
class TicTacToe {

    /** Initialize your data structure here. */
    private int[][] board;
    
    public TicTacToe(int n) {
        this.board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.board[row][col] = player;
        return (checkRow(row, player) || checkCol(col, player)
                || checkDiagonal(row, col, player))? player: 0;
    }
    
    private boolean checkRow(int row, int player){
        for(int i = 0; i < this.board[0].length; i ++){
            if(this.board[row][i] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkCol(int col, int player){
        for(int i = 0; i < this.board.length; i ++){
            if(this.board[i][col] != player){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkDiagonal(int row, int col, int player){
        // topleft -- bottomright
        int m = 0;
        int rowP = row;
        int colP = col;
        while(rowP >= 0 && colP >= 0){
            if(this.board[rowP][colP] == player){
                m ++;
            }
            else{
                break;
            }
            colP --;
            rowP --;
        }
        
        rowP = row + 1;
        colP = col + 1;
        
        while(rowP < this.board.length && colP < this.board.length){
            if(this.board[rowP][colP] == player){
                m ++;
            }
            else{
                break;
            }
            colP ++;
            rowP ++;
        }
        
        if(m >= this.board.length){
            return true;
        }
        
        rowP = row;
        colP = col;
        m = 0;
        
        while(rowP >= 0 && colP < this.board.length){
            if(this.board[rowP][colP] == player){
                m ++;
            }
            else{
                break;
            }
            rowP --;
            colP ++;
        }
        
        rowP = row + 1;
        colP = col - 1;
        
        while(rowP < this.board.length && colP >= 0){
            if(this.board[rowP][colP] == player){
                m ++;
            }
            else{
                break;
            }
            rowP ++;
            colP --;
        }
        
        if(m >= this.board.length){
            return true;
        }
        
        return false;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


