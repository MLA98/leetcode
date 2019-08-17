class Solution {
    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
        new int[] {-1, 0},
        new int[] {1, 0},
        new int[] {0, 1},
        new int[] {0, -1}
    );
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if(m == 0){
            return;
        }
        
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(rooms[i][j] == GATE){
                    q.offer(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] start = q.poll();
            for(int[] direction: DIRECTIONS){
                int row = start[0] + direction[0];
                int col = start[1] + direction[1];
                
                if(row < 0 || col < 0 || col >= n ||
                  row >= m || rooms[row][col] != INF){
                    continue;
                }
                
                rooms[row][col] = rooms[start[0]][start[1]] + 1;
                q.offer(new int[] {row, col});
            }
        }
    }
}