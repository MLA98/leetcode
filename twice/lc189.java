// O(n) O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(end > start){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end --;
            start ++;
        }
    }
}

// O(n) O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        k %= nums.length;
        int[] nums2 = new int[nums.length];
        int j = k - 1;
        for(int i = nums.length - 1; i >= nums.length - k; i --){
            nums2[j] = nums[i];
            j --;
        }
        
        j = k;
        for(int i = 0; i < nums.length - k; i ++){
            nums2[j] = nums[i];
            j ++;
        }
        for(int i = 0; i < nums.length; i ++){
            nums[i] = nums2[i];
        }
    }
}

// 