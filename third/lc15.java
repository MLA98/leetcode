class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int i = 0; i < nums.length - 2; i ++){
            int target = 0 - nums[i];
            if(i == 0 || nums[i] != nums[i - 1]){
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi){
                    if(nums[lo] + nums[hi] == target){
                        List<Integer> subAns = new LinkedList<>();
                        subAns.add(nums[i]);
                        subAns.add(nums[lo]);
                        subAns.add(nums[hi]);
                        ans.add(subAns);
                        while(lo < hi && nums[lo] == nums[lo + 1]){
                            lo ++;
                        }
                        while(lo < hi && nums[hi] == nums[hi - 1]){
                            hi --;
                        }
                        lo ++;
                        hi --;
                    }
                    else if(nums[lo] + nums[hi] < target){
                        lo ++;
                    }
                    else{
                        hi --;
                    }
                }
            }
        }
        
        return ans;
    }
}