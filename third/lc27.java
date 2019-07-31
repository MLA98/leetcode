class Solution {
    public int removeElement(int[] nums, int val) {
        int show = 0;
        int length = nums.length - 1;
        for(int i = 0; i < nums.length;){
            if(i == length - show + 1){
                break;
            }
            if(nums[i] == val){
                swap(nums, i, length - show);
                show ++;
            }
            else{
                i ++;
            }
        }
        
        return nums.length - show;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}