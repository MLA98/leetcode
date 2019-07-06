// sb force: O(n) O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // sb force
        for(int i = 0; i < matrix.length; i ++){
            for(int a: matrix[i]){
                if(a == target){
                    return true;
                }
            }
        }
        return false;
    }
}

//  O(m + n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // O(m + n)
        // edge case!!!
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while(m < matrix.length && n >= 0){
            if(matrix[m][n] < target){
                m ++;
            }
            else if(matrix[m][n] > target){
                n --;
            }
            else{
                return true;
            }
        }
        return false;
    }
}