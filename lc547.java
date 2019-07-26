// Guru's force
class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        
        for(int i = 0; i < M.length; i ++){
            if(visited[i] == 0){
                count ++;
                dfs(visited, M, i);
            }
        }
        
        return count;
    }
    
    private void dfs(int[] visited, int[][] M, int i){
        if(visited[i] == 0){
            visited[i] = 1;
            for(int j = 0; j < M.length; j ++){
                if(visited[j] == 0 && M[i][j] == 1){
                    dfs(visited, M, j);
                }
            }
        }
    }
}

// sb force
class Solution {
    private int[] visited;
    
    public int findCircleNum(int[][] M) {
        int count = 0;
        this.visited = new int[M.length];
            
        for(int i = 0; i < M.length; i ++){
            for(int j = 0; j < M[0].length; j ++){
                if(M[i][j] == 1){
                    count ++;
                    dfs(M, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] M, int i, int j){
        if(i < 0 || i >= M.length || j < 0 || j >= M[0].length){
            return;
        }
        
        if(M[i][j] == 1){
            M[i][j] = 0;
            
            if(visited[j] == 0)
                for(int a = 0; a < M.length; a ++){
                    dfs(M, a, j);
                }
            
            if(visited[i] == 0)
                for(int b = 0; b < M[0].length; b ++){
                    dfs(M, i, b);
                }
        }
    }
}