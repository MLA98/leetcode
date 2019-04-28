class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(candidates);
        btHelper(ansList, new ArrayList<>(), candidates, target, 0);
        return ansList;
    }
    
    private void btHelper(List<List<Integer>> ansList, List<Integer> tempList, int[] candidates, int target, int startP){
        if (target < 0){
            return;
        }
        else if(target == 0){
            ansList.add(new ArrayList<>(tempList));
        }
        else{
            for (int i = startP; i < candidates.length; i ++){
                tempList.add(candidates[i]);
                btHelper(ansList, tempList, candidates, target - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


// basically, a mimic of https://github.com/MLA98/leetcode/blob/5e16d859d3ace6a5ae2dd8ad0be433b4caaf56ca/backtracking_general_approach#L1
// The complexity seems 2^n, n is the length of candidates. Not sure.
