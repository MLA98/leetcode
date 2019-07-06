class Solution {
    // It is a waste of brain and time to solve it. 
    // We could do it with division easily.
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] ans = new int[length];
        
        left[0] = 1;
        for(int i = 1; i < length; i ++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        right[length - 1] = 1;
        for(int i = length - 2; i >= 0; i --){
            right[i] = nums[i + 1] * right[i + 1];
        }
        
        for(int i = 0; i < length; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}

class Solution {
    // It is a waste of brain and time to solve it. 
    // We could do it with division easily.
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        
        ans[0] = 1;
        for(int i = 1; i < length; i ++){
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        
        int R = 1;
        for(int i = length - 2; i >= 0; i --){
            R = R * nums[i + 1];
            ans[i] *= R;
        }

        return ans;
    }
}