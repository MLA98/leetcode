class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        
        int descendIndex = -1;
        
        for(int i = nums.length - 2; i >= 0; i --){
            if(nums[i] < nums[i + 1]){
                descendIndex = i;
                break;
            }
        }
        
        if(descendIndex == -1){
            reverse(nums, 0);
        }
        else{
            int switchIndex = -1;
            for(int j = descendIndex + 1; j < nums.length; j ++){
                if(nums[j] <= nums[descendIndex]){
                    switchIndex = j - 1;
                    swap(nums, descendIndex, switchIndex);
                    reverse(nums, descendIndex + 1);
                    return;
                }
            }
            swap(nums, descendIndex, nums.length - 1);
            reverse(nums, descendIndex + 1);
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    private void reverse(int[] nums, int start){
        int a = start;
        int b = nums.length - 1;
        
        while(a < b){
            swap(nums, a, b);
            a ++;
            b --;
        }
    }
}