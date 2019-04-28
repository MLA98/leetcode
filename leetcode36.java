class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set set1 = new HashSet();
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (board[i][j] != '.'){
                    if (!set1.add(board[i][j] + "row" + i) || !set1.add(board[i][j] + "col" + j) || !set1.add("" + board[i][j] + "" + i/3 + "" + j/3))                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


// Using the hashset to make sure if there is any duplicate numbers in each row, column and subsquare.
// learned: hashset in java & the string manipulation of java.
