class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 && nums.length == 1){
            return;
        }
        int change = -1;
        for (int i = nums.length - 2; i >= 0; i --){
            if (nums[i] < nums[i + 1]){
                change = i;
                break;
            }
        }
        
        if (change == -1){
            reverse(nums, 0);
            return;
        }
        
        int diff = 999999999;
        int smallDiffIndex = 0;
        for (int i = change + 1; i < nums.length; i ++){
            if (nums[i] > nums[change]){
                if (nums[i] - nums[change] < diff){
                    diff = nums[i] - nums[change];
                    smallDiffIndex = i;
                }
            }
        }
        
        int temp = nums[change];
        nums[change] = nums[smallDiffIndex];
        nums[smallDiffIndex] = temp;
        if (nums[change + 1] < nums[change + 2]){
            return;
        }
        reverse(nums, change + 1);
    }
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// My buggy solution. Maybe I am too tired Q.



public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// answer in Solution
