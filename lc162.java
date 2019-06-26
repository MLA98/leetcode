class Solution {
    // should be something like O(n). Simply traverse every element and compare it with its neigbors.
    // but logn is required.
    
    // Algorithm known, How to make it?
    // DIY 
    public int findPeakElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        return helper(0, nums.length - 1, nums);
    }
    
    private int helper(int l, int r, int[] nums){
        if (l == r){
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] < nums[mid + 1]){
            return helper(mid + 1, r, nums);
        }
        else{
            return helper(l, mid, nums);
        }
    }
    // At the end, check the answer. lol feels bad. Hopefully I am not idiot, I am just rusty.
}
