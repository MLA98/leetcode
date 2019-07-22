class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int k = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[k][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                k--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                k--;
            } else {
                j += inc;
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        visited[0] = true;
        int step = 0;
        
        while(!Q.isEmpty()){
            int layerSize = Q.size();
            while(layerSize > 0){
                layerSize --;
                int node = Q.poll();
                if(node == n * n - 1){
                    return step;
                }
                for(int i = node + 1; i < n * n && i <= node + 6; i ++){
                    int des = arr[i] > -1 ? arr[i] - 1 : i; 
                    if(!visited[des]){
                        visited[des] = true;
                        Q.add(des);
                    }
                }
            }
            step ++;
        }
        
        return -1;
    }
}

