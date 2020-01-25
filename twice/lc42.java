class Solution {
    public int trap(int[] height) {
        // Brute force
        // Intuition: for the current bar, find the least tall bar in
        // the left and right
        // Therefore, we can find the amount of water that is stored.
        
        int ans = 0;
        
        for(int i = 0; i < height.length; i ++) {
            int maxRight = height[i];
            int maxLeft = height[i];
            
            for(int j = i; j >= 0; j --) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            
            for(int j = i; j < height.length; j ++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            
            int minTall = Math.min(maxLeft, maxRight);
            
            ans += minTall - height[i];
        }
        
        return ans;
    }
}

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        // Easy DP. Storing the max.
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int ans = 0;
        
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];
        
        for(int i = 1; i < height.length; i ++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        
        for(int i = height.length - 2; i >= 0; i --) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        
        for(int i = 0; i < height.length; i ++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return ans;
    }
}
