class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while(right >= left){
            mid = left + (right - left) / 2;
            if(target == nums[mid]){
                return mid;
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
        
        return -1;
    }
}
// The core is to find the place that is sorted and may include the target;
// Be careful about the corner case like the left == mid or [3, 1] or [1]