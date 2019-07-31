class Solution {
    public int[] twoSum(int[] nums, int target) {
    // shit I forgot how to do it in this short time.
        Map<Integer, Integer> complements = new HashMap<>();
        int complement = 0;
        int ans[] = new int[2];
        for (int i = 0; i < nums.length; i ++){
            complement = target - nums[i];
            if (complements.containsKey(complement)){
                ans[0] = complements.get(complement);
                ans[1] = i;
                return ans;
            }
            else{
                complements.put(nums[i], i);
            }
        }
        return ans;
    }
}

// not really need to say... just easy hashmap.
