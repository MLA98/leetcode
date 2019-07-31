class Solution {
    public int removeDuplicates(int[] nums) {
        // wdnmd
        if(nums.length == 0){
            return 0;
        }
        int pre = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i ++){
            if(pre != nums[i]){
                pre = nums[i];
                count ++;
                swap(nums, count - 1, i);
            }
        }
        return count;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}