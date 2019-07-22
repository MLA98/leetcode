class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(0, 0, ans, n, "");
        return ans;
    }
    
    private void bt(int left, int right, List<String> ans, int max, String cur){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        
        if(left > right){
            bt(left, right + 1, ans, max, cur + ")");
        }
        if(left < max){
            bt(left + 1, right, ans, max, cur + "(");
        }
    }
}