class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        bthelper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    private void bthelper(int start, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }   
        else if(target < 0){
            return;
        }
        
        for(int i = start; i < candidates.length; i ++){
            temp.add(candidates[i]);
            bthelper(i, candidates, target - candidates[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}


// basically, a mimic of https://github.com/MLA98/leetcode/blob/5e16d859d3ace6a5ae2dd8ad0be433b4caaf56ca/backtracking_general_approach#L1
// The complexity seems 2^n, n is the length of candidates. Not sure.
