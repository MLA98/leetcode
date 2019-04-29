class Solution {
    public int climbStairs(int n) {
        // List<String> animals = new ArrayList<>();
        if (n == 1){
            return 1;
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        for (int i = 2; i < n; i ++){
            ans.add(ans.get(i - 1) + ans.get(i - 2));
        }
        
        return ans.get(ans.size() - 1);
    }
}
