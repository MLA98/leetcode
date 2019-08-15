class Solution {
    Random random;
    int[] cummulate;
        
    public Solution(int[] w) {
        this.random = new Random();
        for(int i = 1; i < w.length; i ++){
            w[i] += w[i - 1];
        }
        
        cummulate = w;
    }
    
    public int pickIndex() {
        int len = cummulate.length;
        int rand = random.
            nextInt(cummulate[len - 1]) + 1;
        int left = 0;
        int right = cummulate.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(rand > cummulate[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */