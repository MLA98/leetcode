class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i ++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            
            List<List<Integer>> partialAns = 
                threeSum(nums, target - nums[i], i + 1, nums[i]);
            ans.addAll(partialAns);
        }
        
        return ans;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int targetA, int start, int first) {
        List<List<Integer>> ans = new LinkedList<>();
        
        for(int i = start; i < nums.length - 2; i ++){
            int target = targetA - nums[i];
            if(i == start || nums[i] != nums[i - 1]){
                int lo = i + 1;
                int hi = nums.length - 1;
                while(lo < hi){
                    if(nums[lo] + nums[hi] == target){
                        List<Integer> subAns = new LinkedList<>();
                        subAns.add(first);
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