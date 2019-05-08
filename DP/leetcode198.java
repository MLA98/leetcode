class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        else if (nums.length == 1){
            return nums[0];
        }
        else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] maxDp = new int[nums.length];
        maxDp[0] = nums[0];
        maxDp[1] = nums[1];
        maxDp[2] = nums[2] + nums[0];
        for (int i = 3; i < nums.length; i ++){
            maxDp[i] = nums[i] + Math.max(maxDp[i - 3], maxDp[i - 2]);
        }
        int max = 0;
        for (int j = 0; j < nums.length; j ++){
            if (max < maxDp[j]){
                max = maxDp[j];
            }
        }
        return max;
    }
}
