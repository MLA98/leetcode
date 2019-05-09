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
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }
        Boolean firRowZero = false;
        for (int i = 0; i < matrix[0].length; i ++){
            if (matrix[0][i] == 0){
                firRowZero = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i ++){
            for (int j = matrix[0].length - 1; j >= 0; j --){
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if (firRowZero){
            Arrays.fill(matrix[0], 0);
        }
        
    }
}

// Copied. 2x faster. Using the first row and first column as the tag.
