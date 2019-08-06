// O(m + n) time/ space
class Solution {
    public void gameOfLife(int[][] board) {
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                nextGen(i, j, board);
            }
        }
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == 11){
                    board[i][j] = 0;
                }
                else if(board[i][j] == 10){
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private void nextGen(int currI, int currJ, int[][] board){
        int[] neighbors = {0, 1, -1};
        int neighberLives = 0;
        
        for(int a = 0; a < 3; a ++){
            for(int b = 0; b < 3; b ++){
                int i = neighbors[a];
                int j = neighbors[b];
                if((i == 0 && j == 0) || (currI + i < 0 ||
                  currI + i >= board.length || currJ + j < 0
                  || currJ + j >= board[0].length)){
                    continue;
                }
                
                if(board[currI + i][currJ + j] % 10 == 1){
                    neighberLives ++;
                }
            }
        }
        
        if(board[currI][currJ] == 0){
            if(neighberLives == 3){
                board[currI][currJ] = 10;
            }
        }
        else{
            if(neighberLives != 3 && neighberLives != 2){
                board[currI][currJ] = 11;
            }
        }
    }
}


// O(m + n) time / O(m + n ) space Bug free :) 
class Solution {
    public void gameOfLife(int[][] board) {
        int[][] boardCopy = new int[board.length + 2][board[0].length + 2];
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                boardCopy[i + 1][j + 1] = board[i][j];
            }
        }
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                board[i][j] = nextGen(i + 1, j + 1, boardCopy)?
                    1: 0;
            }
        }
    }
    
    private boolean nextGen(int currI, int currJ, int[][] board){
        int neighborsLive = board[currI + 1][currJ + 1] + board[currI - 1][currJ - 1]
            + board[currI - 1][currJ + 1] + board[currI + 1][currJ - 1]
            + board[currI][currJ + 1] + board[currI][currJ - 1]
            + board[currI + 1][currJ] + board[currI - 1][currJ];
        
        if(board[currI][currJ] == 1){
            if(neighborsLive == 3 || neighborsLive == 2){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(neighborsLive == 3){
                return true;
            }
            else{
                return false;
            }
        }
    }
}