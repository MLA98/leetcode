class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bthelper(ans, new ArrayList<>(), nums);
        return ans;
    }
    
    private void bthelper(List<List<Integer>> ans, List<Integer> tempans, int[] nums){
        if (tempans.size() == nums.length){
            ans.add(new ArrayList<>(tempans));
        }
        else{
            for (int i = 0; i < nums.length; i ++){
                if (tempans.contains(nums[i])){
                    continue;
                }
                else{
                    tempans.add(nums[i]);
                    bthelper(ans, tempans, nums);
                    tempans.remove(tempans.size() - 1);
                }
            }
        }
            
    }
}

// backtracking for permutation. This method could remove some duplicated recursion but that's it.
