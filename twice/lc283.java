class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        int arrayIndex = 0;
        
        while(arrayIndex < nums.length) {
            if(nums[arrayIndex] == 0 && zeroIndex == -1){
                zeroIndex = arrayIndex;
            }
            
            if(nums[arrayIndex] != 0 && zeroIndex != -1){
                swap(nums, arrayIndex, zeroIndex);
                zeroIndex ++;
            }
            
            arrayIndex ++;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}