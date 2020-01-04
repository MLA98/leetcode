class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        if(k == 0) {
            return ans;
        }
        
        bt(1, n, k, ans, new ArrayList<>());
        return ans;
    }
    
    private void bt(int start, int end, int count, List<List<Integer>> ans, List<Integer> temp) {
        if(temp.size() == count) {
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i = start; i <= end; i ++) {
            temp.add(i);
            bt(i + 1, end, count, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}