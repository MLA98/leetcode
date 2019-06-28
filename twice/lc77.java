class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // backtracking ?
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        bthelper(ans, track, 1, n, k);
        return ans;
    }
    
    private void bthelper(
        List<List<Integer>> ans, 
        List<Integer> track,
        int start,
        int n,
        int k){
        if (k == 0){
            ans.add(new ArrayList<Integer>(track));
            return;
        }
        
        for (int i = start; i <= n; i ++){
            track.add(i);
            bthelper(ans, track, i + 1, n, k - 1);
            track.remove(track.size() - 1);
        }
    }
}

// backtracking & DFS! 
