class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int mod = 0;
        Set<Integer> set = new HashSet<>();
        
        // Only if two consecutive 0 could make k == 0 case to be true; In the same time, 
        // two consecutive 0s could make any k to be true;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == 0 && nums[i - 1] == 0){
                return true;
            }
        }
        
        if(k == 0){
            return false;
        }
        
        int prev = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            mod = sum % k;
            if(mod == 0 && i > 0){
                return true;
            }
            else if(set.contains(mod) && prev != mod){
                return true;
            }
            
            prev = mod;
            set.add(mod);
        }
        
        return false;
    }
}