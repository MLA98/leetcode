class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(m + n) solution
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length - 1;
        int n = 0;
        
        while(m >= 0 && n < matrix[0].length){
            if(matrix[m][n] == target){
                return true;
            }
            else if(matrix[m][n] < target){
                n ++;
            }
            else{
                m --;
            }
        }
        
        return false;
    }
}
//硬记吧，m+n的算法，记住就完事了！