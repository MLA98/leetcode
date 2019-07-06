class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        bthelper(ans, temp, nums, 0);
        return ans;
    }
    
    private void bthelper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start){
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i ++){
            temp.add(nums[i]);
            bthelper(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// feels bad, it should be easy but I could not finish it by myself.!!
// Look up ans, then do it.
// Need review and practice!!
