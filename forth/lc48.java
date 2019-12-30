class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }
        
        int length = matrix.length;
        
        for(int i = 0; i < length; i ++){
            for(int j = 0; j < length / 2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }
        
        for(int i = 0; i < length; i ++){
            for(int j = 0; j < length - i - 1; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = temp;
            }
        }
    }
}