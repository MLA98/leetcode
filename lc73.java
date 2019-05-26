class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        
        List<String> zeroes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == 0){
                    zeroes.add(Integer.toString(i) + "/" + Integer.toString(j));
                }
            }
        }
        for (String zero: zeroes){
            int row = Integer.parseInt(zero.split("/")[0]);
            int col = Integer.parseInt(zero.split("/")[1]);
            for (int i = 0; i < matrix.length; i ++){
                matrix[i][col] = 0;
            }
            for (int i = 0; i < matrix[0].length; i ++){
                matrix[row][i] = 0;
            }
        }
    }
}

// Using O(m * n) space in worst case, but in general case. The space usage
// is quite good. The problem is about efficiency. The String manipulation
// is really slow.

class Solution {
    // N^3 bruteforce. Find one 0 and go through the cross and set 
    // them to zero
    // I feel like I can use a tag in every first row and first column
    // Which could make it to n^2
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int rowZero = 0;
        int colZero = 0;
        for (int i = 0; i < matrix.length; i ++){
            if (matrix[i][0] == 0){
                colZero = 1;
                break;
            }
        }
        for (int j = 0; j < matrix[0].length; j ++){
            if (matrix[0][j] == 0){
                rowZero = 1;
                break;
            }
        }
        
        for (int i = 1; i < matrix.length; i ++){
            for (int j = 1; j < matrix[0].length; j ++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i ++){
            for (int j = 1; j < matrix[0].length; j ++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (rowZero == 1){
            for (int j = 0; j < matrix[0].length; j ++){
                matrix[0][j] = 0;
            } 
        }
        if (colZero == 1){
            for (int j = 0; j < matrix.length; j ++){
                matrix[j][0] = 0;
            } 
        }
    }
}

// Copied. 2x faster. Using the first row and first column as the tag.
