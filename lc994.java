import javafx.util.Pair; 

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue  = new LinkedList<>();
        int[][] surround = {{0 ,1}, {0, -1}, {1, 0}, {-1, 0}};
        
        int nonZeroCount = 0;
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
                
                if(grid[i][j] != 0){
                    nonZeroCount ++;
                }
            }
        }
        
        if(nonZeroCount == 0){
            return 0;
        }
        
        int layer = 0;
        
        
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            layer ++;
            
            for(int i = 0; i < size; i ++){
                Pair rotten = queue.poll();
                for(int[] surr : surround){
                    int index1 = (int)rotten.getKey() + surr[0];
                    int index2 = (int)rotten.getValue() + surr[1];
                    
                    if(index1 >= 0 && index1 < grid.length && 
                        index2 >= 0 && index2 < grid[0].length) {
                        if(grid[index1][index2] == 1) {
                            grid[index1][index2] = 2;
                            queue.offer(new Pair(index1, index2));
                        }
                    }
                }    
            }
        }
        
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return layer - 1;
    }
}