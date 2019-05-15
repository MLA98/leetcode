class Solution {
    public void nextPermutation(int[] nums){
        int lower =  -1;
        // Find the number which gets lower first
        for (int i = nums.length - 2; i >= 0; i --){
            if (nums[i] < nums[i + 1]){
                lower = i;
                break;
            }
        }
        
        if (lower == -1){
            reverse(nums, 0);
            return;
        }
        
        // Find the closest larger number to the lower
        int closetLarger = 0;
        for (int i = lower + 1; i < nums.length; i ++){
            closetLarger = i;
            if (nums[i] <= nums[lower]){
                closetLarger = i - 1;
                break;
            }
        }
        swap(nums, closetLarger, lower);
        reverse(nums, lower + 1);
        
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

// My correct solution. Maybe I am too tired Q.



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
