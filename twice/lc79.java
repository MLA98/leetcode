class Solution {
    public boolean exist(char[][] board, String word) {
        // backtracking DFS
        if (board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word.length() == 0){
            return true;   
        }
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (helper(board, wordArray, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
        
    
    private boolean helper(char[][] board, char[] word, int i, int j, int index){
        if (index == word.length){
            return true;
        }
        if (i >=  board.length || i < 0 || 
            j >= board[0].length || j < 0){
            return false;
        }
        if (board[i][j] - word[index] != 0){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '1';
        boolean res = helper(board, word, i + 1, j, index + 1) 
            || helper(board, word, i, j + 1, index + 1)
            || helper(board, word, i - 1, j , index + 1)
            || helper(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return res;
    }
}
