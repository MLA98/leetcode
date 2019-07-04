class Solution {
    // Hec, try to get brute force one shot dude.
    public int minSubArrayLen(int s, int[] nums) {
        // brute force
        int[] sizes = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            int sum = 0;
            for(int j = i; j < nums.length; j ++){
                sum += nums[j];
                if(sum >= s){
                    sizes[i] = j - i + 1;
                    break;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(sizes[i] > 0){
                min = Math.min(min, sizes[i]);
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}

// O(n) Solution 牛逼嗷
class Solution { 
    // O(n) solution
    public int minSubArrayLen(int s, int[] nums) {
        // This solution is just brilliant
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            while(sum >= s){
                min = Math.min(i - left + 1, min);
                sum -= nums[left];
                left ++;
            }
        }
        if(Integer.MAX_VALUE == min){
            return 0;
        }
        return min;
    }
}