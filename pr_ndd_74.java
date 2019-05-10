class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows - 1;
        int midr = 0;
        while (left <= right){
            midr = left + (right - left) / 2;
            if (matrix[midr][0] <= target && target <= matrix[midr][cols - 1]){
                break;
            }
            else if (matrix[midr][0] > target){
                right = midr - 1;
            }
            else if (matrix[midr][cols - 1] < target){
                left = midr + 1;
            }
        }
        for (int elem : matrix[midr]){
            if (elem == target){
                return true;
            }
        }
        return false;
    }
}

// My code, find the row that may contain the target by binary Search.
// Used only mid to trace the binary search which is proven to be shitty.
// Use left and right to track binary search !!!!!
// Running time O(log(m)) + O(n)

  
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
    int rowSize = matrix.length, colSize = matrix[0].length;
    for(int i=0; i<rowSize; i++) {
        if(target >= matrix[i][0] && target <= matrix[i][colSize-1]) {
            return binarySearch(matrix[i], 0, colSize-1, target);
        }
    }
    return false;
}

public boolean binarySearch(int[] array, int start, int end, int target) {
    if(start > end) return false;
    int middle = (start + end) / 2;
    if(array[middle] == target) return true;
    else if(array[middle] < target) return binarySearch(array, middle+1, end, target);
    else return binarySearch(array, start, middle-1, target);
}
}


// Binary search the whole matrix, is faster. O(log(m + n)). Try next time
