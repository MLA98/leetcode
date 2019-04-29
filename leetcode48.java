class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i< matrix.length; i ++){
            for (int j = i; j < matrix[0].length; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =temp;
            }
        } // transpose
        
        for (int i = 0; i< matrix.length; i ++){ // flip row
            for (int j = 0; j < matrix[0].length / 2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        } 
    }
}

// Remember the trick. The transpose double for loop has i = 0; j = i; index


