// O(n) 
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int prev = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(prev > nums[i]){
                return nums[i];
            }
            prev = nums[i];
        }
        return nums[0];
    }
}

// O(logn)
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int l = 0;
        int r = nums.length - 1;
        if(nums[r] > nums[0]){
            return nums[0];
        }
        int mid;
        while(r >= l){
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if(nums[mid] > nums[0]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return -1;
    }
}