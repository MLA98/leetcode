// Optimal one
// O(m * n) time & O(1) space
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return;
        }
        int n = matrix[0].length;
        boolean isCol = false;
        boolean isRow = false;
        
        for(int i = 0; i < m; i ++){
            if(matrix[i][0] == 0){
                isCol = true;
                break;
            }
        }
        
        for(int j = 0; j < n; j ++){
            if(matrix[0][j] == 0){
                isRow = true;
                break;
            }
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(isCol){
            for(int i = 0; i < m; i ++){
                matrix[i][0] = 0;
            }
        }
        
        if(isRow){
            for(int i = 0; i < n; i ++){
                matrix[0][i] = 0;
            }
        }
    }
}

// time: O(m * n)
// space: O(m + n)

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        
        int R = matrix.length;
        if(R == 0){
            return;
        }
        
        int C = matrix[0].length;

        for(int r = 0; r < R; r ++){
            for(int c = 0; c < C; c ++){
                if(matrix[r][c] == 0){
                    row.add(r);
                    col.add(c);
                }
            }
        }
        
        for(int r = 0; r < R; r ++){
            for(int c = 0; c < C; c ++){
                if (row.contains(r) || col.contains(c)) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}

// WRONG soln as the MODIFIED could be used 
// Time: O(M x N)(M + N);
// O(1);
class Solution {
    private int MODIFIED = -1000000;
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        if(R == 0){
            return;
        }
        
        int C = matrix[0].length;

        for(int r = 0; r < R; r ++){
            for(int c = 0; c < C; c ++){
                if(matrix[r][c] == 0){
                    for(int k = 0; k < C; k ++){
                    if (matrix[r][k] != 0)
                        matrix[r][k] = MODIFIED;
                    }
        
                    for(int k = 0; k < R; k ++){
                    if (matrix[k][c] != 0)
                        matrix[k][c] = MODIFIED;
                    }
                }
            }
        }
        
        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j ++){
                if(matrix[i][j] == MODIFIED){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}