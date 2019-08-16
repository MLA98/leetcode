// Naive appraoch 
// O(nk) which is shitty
// O(1)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < 2){
            return nums;
        }

        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        
        for(int i = k - 1; i < nums.length; i ++){
            int curMax = Integer.MIN_VALUE;
            for(int j = i - k + 1; j <= i; j ++){
                curMax = Math.max(curMax, nums[j]);
            }
            ans[index] = curMax;
            index ++;
        }
        
        return ans;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n < 2){
            return nums;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[nums.length - k + 1];
        
        for(int i = 0; i < n; i ++){
            if(i % k == 0){
                left[i] = nums[i];
            }
            else{
                left[i] = Math.max(nums[i], left[i - 1]);
            }
        }
        
        for(int i = n - 1; i >= n - (n % k); i --){
            if(i == n - 1){
                right[i] = nums[i];
            }
            else{
                right[i] = Math.max(nums[i], right[i + 1]);
            }
        }
        
        for(int i = n - (n % k) - 1; i >= 0; i --){
            if((i + 1) % k == 0){
                right[i] = nums[i];
            }
            else{
                right[i] = Math.max(nums[i], right[i + 1]);
            }
        }
        
        for(int i = 0; i <= n - k; i ++){
            ans[i] = Math.max(right[i], left[i + k - 1]);
        }
        
        return ans;
    }
}