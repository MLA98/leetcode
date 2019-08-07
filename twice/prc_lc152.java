// O(n^2) O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curVal = 0;
        for(int i = 0; i < nums.length; i ++){
            curVal = 1;
            for(int j = i; j < nums.length; j ++){
                curVal *= nums[j];
                max = Math.max(curVal, max);
            }
        }
        
        return max;
    }
}


// O(n) O(n)
class Solution {
    public int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] < 0){
                maxProduct[i] = Math.max(minProduct[i - 1] * nums[i], nums[i]);
                minProduct[i] = Math.min(maxProduct[i - 1] * nums[i], nums[i]);
            }
            else{
                maxProduct[i] = Math.max(maxProduct[i - 1] * nums[i], nums[i]);
                minProduct[i] = Math.min(minProduct[i - 1] * nums[i], nums[i]);
            }
            
            max = Math.max(maxProduct[i], max);
        }
        
        return max;
    }
}


// O(n) O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
                maxProduct = Math.max(maxProduct * nums[i], nums[i]);
                minProduct = Math.min(minProduct * nums[i], nums[i]);
            }
            else{
                maxProduct = Math.max(maxProduct * nums[i], nums[i]);
                minProduct = Math.min(minProduct * nums[i], nums[i]);
            }
            
            max = Math.max(maxProduct, max);
        }
        
        return max;
    }
}