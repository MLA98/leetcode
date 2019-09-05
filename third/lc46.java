class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        bt(ans, nums, new ArrayList<Integer>());
        return ans;
    }
    
    private void bt(List<List<Integer>> ans, int[] nums, 
                   List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int n: nums){
            if(!temp.contains(n)){
                temp.add(n);
                bt(ans, nums, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}