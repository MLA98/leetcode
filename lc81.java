class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            
            // 确保极端值是正确的
            while(left < right && nums[left] == nums[right]){
                right --;
            }
            
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                return true;
            }
            
            if(nums[mid] >= nums[left]){
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                // right part is already sorted.
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }
}