// Two pass
class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = 0;
        
        for(int num: nums){
            red = num == 0? red + 1: red;
            white = num == 1? white + 1: white;
            blue = num == 2? blue + 1: blue;
        }
        
        for(int i = 0; i < red; i ++){
            nums[i] = 0;
        }
        
        for(int i = red; i < red + white; i ++){
            nums[i] = 1;
        }
        
        for(int i = red + white; i < red + blue + white; i ++){
            nums[i] = 2;
        }
    }
}


// One pass
class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;
        
        while(i < nums.length){
            if(nums[i] == 0 && i > zeroIndex){
                swap(nums, i, zeroIndex);
                zeroIndex ++;
            }
            else if(nums[i] == 2 && i < twoIndex){
                swap(nums, i, twoIndex);
                twoIndex --;
            }
            else{
                i ++;
            }
        }
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}