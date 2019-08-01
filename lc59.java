class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        
        int r1, r2, c1, c2;
        r1 = 0;
        r2 = ans.length - 1;
        c1 = 0;
        c2 = ans[0].length - 1;
        int tok = 1;
        
        while(r1 <= r2 && c1 <= c2){
            for(int i = c1; i <= c2; i ++){
                ans[r1][i] = tok;
                tok ++;
            }
            
            for(int i = r1 + 1; i <= r2; i ++){
                ans[i][c2] = tok;
                tok ++;
            }
            
            // No more squares exist
            if(r1 < r2 && c1 < c2){
                for(int i = c2 - 1; i > c1; i --){
                    ans[r2][i] = tok;
                    tok ++;
                }
                
                for(int i = r2; i > r1; i --){
                    ans[i][c1] = tok;
                    tok ++;
                }
            }
            
            c1 ++;
            c2 --;
            r1 ++;
            r2 --;
        }
        
        return ans;
    }
}