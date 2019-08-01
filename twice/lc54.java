class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList<Integer>();
        if (matrix.length == 0){
            return ans;
        }
        
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        
        while (r1 <= r2 && c1 <= c2){
            for (int i = c1; i <= c2; i ++){
                ans.add(matrix[r1][i]);
            }
            for (int j = r1 + 1; j <= r2; j ++){
                ans.add(matrix[j][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int k = c2 - 1; k > c1; k --){
                    ans.add(matrix[r2][k]);
                }
                for (int q = r2; q > r1; q --){
                    ans.add(matrix[q][c1]);
                }
            }
            r1 ++;
            c1 ++;
            r2 --;
            c2 --;
        }
        return ans;
    }
}

// Kinda not interesting problem. This scenario could be solved by pointers!!!!