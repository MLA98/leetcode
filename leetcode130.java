class Solution {
    // My assumption is that the core of this problem is the border Os.
    // They are determinant in this problem.
    // I probably would go through four edges in the square and record the area.
    // Using a recursive helper function around the border Os to find the Os connected
    // to the border Os.
    // Finding boarder is O(n)
    // getting the locations of Os inside is O(n^2)
    // Flipping O(n^2)
    // O(n^2)
    // O(1) space.
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0){
            return;
        }
        for (int i = 0; i < board[0].length; i++){
            if (board[0][i] == 'O'){
                helper(0, i, board);
            }
            if (board[board.length - 1][i] == 'O'){
                helper(board.length - 1, i, board);
            }
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == 'O'){
                helper(i, 0, board);
            }
            if (board[i][board[0].length - 1] == 'O'){
                helper(i, board[0].length - 1, board);
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
    
    private void helper(int i, int j, char[][] board){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if (board[i][j] == 'O'){
            board[i][j] = '*';
            helper(i - 1, j, board);
            helper(i + 1, j, board);
            helper(i, j + 1, board);
            helper(i, j - 1, board);
        }
    }
    // I used customized tuple at first but failed because of slowness
    // The way to do is correct!!!!
    // Make them to '*' to leave tuple alone!
    // After getting this, I make it bug free!
    // Not bad!
}
