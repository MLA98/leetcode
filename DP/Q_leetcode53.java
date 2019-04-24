class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = -99999999;
        int curSum = -99999999;
        for (int i = 0; i < nums.length; i ++){
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSoFar = Math.max(curSum, maxSoFar);
        }
        return maxSoFar;
    }
}


// What to do with this kind of corner case?
