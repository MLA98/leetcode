class Solution {
    public int rob(int[] nums) {      
        if(nums.length == 0){
            return 0;
        }
        
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            if(i == 2){
                nums[i] = nums[i] + nums[0];
            }
            else if(i > 2){
                nums[i] += Math.max(nums[i - 2], nums[i - 3]);
            }
            
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}