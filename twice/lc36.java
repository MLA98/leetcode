class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board.length; j ++){
                char c = board[i][j];
                if(c != '.'){
                    if(!set.add("row" + i + "have" + c) ||
                    !set.add("col" + j + "have" + c) ||
                    !set.add("block" + i / 3 + "-" + j / 3 + "have" + c)){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}