class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null){
            return (new ArrayList<>());
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        bt(nums, ans, new ArrayList<Integer>());
            
        return ans;
    }
    
    private void bt(int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
        }
        
        for(int num : nums) {
            if(!temp.contains(num)) {
                temp.add(num);
                bt(nums, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}