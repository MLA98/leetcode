class Solution {
    public int searchInsert(int[] nums, int target) {
        // lgn? 
        if(nums.length == 0){
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1; // Be careful!
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(mid - 1 >= 0 && nums[mid] >= target &&
              nums[mid - 1] < target){
                return mid;
            }
            else if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        
        return right < 0? 0: nums.length;
    }
}