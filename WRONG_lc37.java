class Solution {
    int n = 3;
    int N = n * n;
    boolean[][] rows = new boolean[N][N + 1];
    boolean[][] cols = new boolean[N][N + 1];
    boolean[][] box = new boolean[N][N + 1];
    boolean solved = false;
    char[][] board;

    private boolean couldPlace(int d, int row, int col){
        int idx = (row / 3) * 3 + col / 3;        
        return !(rows[row][d] || cols[col][d] || box[idx][d]);
    }
    
    private void placeNumber(int d, int row, int col){
        int idx = (row / 3) * 3 + col / 3;
        
        rows[row][d] = true;
        cols[row][d] = true;
        box[idx][d] = true;
        board[row][col] = (char)(d + '0');
    }
    
    private void delete(int d, int row, int col){
        int idx = (row / 3) * 3 + col / 3; 
        rows[row][d] = false;
        cols[row][d] = false;
        box[idx][d] = false;
        board[row][col] ='.';
    }
    
    private void placeNext(int row, int col){
        if((row == N - 1) && (col == N - 1)){
            solved = true;
        }
        else if(col == N - 1){
            backtrack(row + 1, 0);
        }
        else{
            backtrack(row, col + 1);
        }
    }


    private void backtrack(int row, int col){
        // try every number from 1 to 9 and try nex etc
        if(board[row][col] == '.'){
            for(int i = 1; i <= 9; i ++){
                if(couldPlace(i, row, col)){
                    placeNumber(i, row, col);
                    placeNext(row, col);
                }
                
                if(!solved){
                    delete(i, row, col);
                }
            }
        }
        else{
            placeNext(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        // init rows, columns and boxes
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            char num = board[i][j];
            if (num != '.') {
              int d = num - '0';
              placeNumber(d, i, j);
            }
          }
        }
        backtrack(0, 0);
    }
}