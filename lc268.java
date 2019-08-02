class Solution {
    public int missingNumber(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        
        
        for(int i = 0; i < nums.length + 1; i ++){
            if(i < nums.length){
                sum1 += nums[i];
            }
            sum2 += i;
        }
        
        return sum2 - sum1;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        
        for(int num: nums){
            missing ^= num;
        }
        
        for(int i = 0; i < nums.length; i ++){
            missing ^= i;
        }
        
        return missing;
    }
}