// O(logn) soln
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            int prev = mid == 0? Integer.MIN_VALUE: nums[mid - 1];
            int after = mid == nums.length - 1? Integer.MIN_VALUE: nums[mid + 1];
            
            if(nums[mid] >= prev && nums[mid] >= after){
                return mid;
            }
            else if(nums[mid] >= prev && nums[mid] <= after){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        return r;
    }
}



// O(n) solution
class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0; i < nums.length; i ++){
            int prev = i == 0? Integer.MIN_VALUE: nums[i - 1];
            int after = i == nums.length - 1? Integer.MIN_VALUE: nums[i + 1];
            
            if(nums[i] >= prev && nums[i] >= after){
                return i;
            }
        }
        
        return -1;
    }
}