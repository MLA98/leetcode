// sb force
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        
        for(int i = 0; i < nums.length; i ++){
            int sum = nums[i];
            if(sum == k){
                ans ++;
            }
            for(int j = i + 1; j < nums.length; j ++){
                sum += nums[j];
                if(sum == k){
                    ans ++;
                }
            }
        }
        
        return ans;
    }
}

// Hashmap solution.
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // The void prefix but we should include it.
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}