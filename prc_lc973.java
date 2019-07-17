class Solution {
    // O(nlogn) time & O(n) space solution
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        int[] distances = new int[points.length];
        for(int i = 0; i < points.length; i ++){
            distances[i] = distance(points[i]);
        }
        
        Arrays.sort(distances);
        int cap = distances[K - 1];
        int breakI = 0;
        for(int i = 0; i < points.length; i ++){
            if(breakI >= K){
                break;
            }
            if(distance(points[i]) <= cap){
                ans[breakI] = points[i];
                breakI ++;
            }
        }
        return ans;
    }
    
    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

