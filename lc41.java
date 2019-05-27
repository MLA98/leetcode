class Solution {
    // Looks easy to me lel
    // It is hard bro
    // traverse the nums and 
    public int firstMissingPositive(int[] nums) {
        int ans = 1;
        for (int i = 0; i < nums.length;){
            if (nums[i] <= 0){
                i ++;
            }
            else if (nums[i] > nums.length){
                i ++;
            }
            else if (i == nums[i] - 1){
                i ++;
            }
            else if (nums[i] == nums[nums[i] - 1]){
                i ++;
            }
            else{
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i ++){
            if (ans != nums[i]){
                break;
            }
            else{
                ans ++;
            }
        }
        return ans;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// HAPPY, 30 minutes. Two lines to a correct answer
// It is hard !!!!!
