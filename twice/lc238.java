// sb force 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i ++){
            int product = 1;
            for(int j = 0; j < nums.length; j ++){
                if(j != i){
                    product *= nums[j];
                }
            }
            ans[i] = product;
        }
        
        return ans;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        
        for(int i = 1; i < nums.length; i ++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        for(int i = nums.length - 2; i >= 0; i --){
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < nums.length; i ++){
            ans[i] = right[i] * left[i];
        }
        
        return ans;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[nums.length - 1] = 1;
        
        for(int i = nums.length - 2; i >= 0; i --){
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        
        int left = 1;
        for(int i = 0; i < nums.length; i ++){
            ans[i] = ans[i] * left;
            left *= nums[i];
        }
        
        return ans;
    }
}