class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        
        int r,g,b;
        r = g = b = 0;
        
        for(int i = 0; i < costs.length; i ++){
            int tempR, tempG, tempB;
            tempR = r;
            tempG = g;
            tempB = b;
            r = Math.min(tempG, tempB) + costs[i][0];
            g = Math.min(tempR, tempB) + costs[i][1];
            b = Math.min(tempR, tempG) + costs[i][2];
        }
        
        return Math.min(r, Math.min(g, b));
    }
}