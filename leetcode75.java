class Solution {
    public void sortColors(int[] nums) {
        // Think of the same solution as others... Though it was not one-pass.
        int zeros = 0;
        int twos = nums.length - 1;
        for (int i = 0; i < nums.length && i <= twos;){
            if (nums[i] == 0 && i > zeros){
                swap(nums, i, zeros);
                zeros ++;
            }
            else if(nums[i] == 2 && i < twos){
                swap(nums, i, twos);
                twos --;
            }
            else{
                i ++;
            }
        }
        // After each swap, the pointer of for loop (i) would stay the same
        // Therefore, tha array[i] would be tested again. 
        // This algorithm could make sure every 0 or 2 will in the different 
        // in the array. Intuitively, the 1s are in the middle eventually.
    }
    
    private void swap (int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
