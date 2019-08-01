// O(logmn) + O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int right = m * n - 1;
        int left = 0;
        int mid = 0;
        int row = 0;
        int col = 0;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            int num = matrix[mid / n][mid % n];
            if(num == target){
                return true;
            }
            else if(num > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return false;
    }
}