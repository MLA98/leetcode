class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1){
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        
        for(int i = nums.length - 2; i >= 0 ; i --){
            for(int j = i + 1; j < nums.length; j ++){
                if(nums[i] < nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        
        return max + 1;
    }
}