// O(n) + O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if(nums.length == 0){
            return ans;
        }
        
        boolean found = false;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target && !found){
                found = true;
                ans[0] = i;
            }
            
            if(found && nums[i] == target){
                ans[1] = i;
            }
        }
        
        return ans;
    }
}


// O(lgn) time, the core is to use >= and <= to find the left and right boundary value;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        boolean found = false;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                found = true;
                break;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        if(!found){
            return ans;
        }
        
        int leftSave = left;
        int rightSave = right;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            
            if(nums[mid] == target){
                ans[0] = mid;
            }
        }
        
        left = leftSave;
        right = rightSave;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
            
            if(nums[mid] == target){
                ans[1] = mid;
            }
        }
        
        return ans;
    }
}


