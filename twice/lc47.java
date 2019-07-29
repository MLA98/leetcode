class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    
    private void helper(List<List<Integer>> ans, int[] nums, List<Integer> temp, boolean[] used){
        if (temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i ++){
            // Kinda complex logic. Since the array is sorted. The control flow will check if the 
            // element before the i is the same. If it is same and the nums[i-1] is not used in the 
            // temp list. Then the rest of the control flow will be skipped. Since in that scenario,
            // An function call with the same element was issued already.
            // This control flow ensures that in the ans list, in each inderx of the list, same element
            // would only show up once.
            if ((used[i]) || (i > 0 && nums[i] == nums[i - 1] && !used[i-1])){
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            helper(ans, nums, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
        
    }
}

// The variant to lc 46. There might be some duplicated element in the array.
