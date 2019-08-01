// O(n) hashmap method with O(n) space complexity.

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        
        for(int num: nums){
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        for(int key: map.keySet()){
            if(map.get(key) == 1){
                return key;
            }
        }
        
        return -1;
    }
}

// O(1) space complexity solution
class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        int ans = 0;
        
        for(int i = 0; i < 32; i ++){
            for(int j = 0; j < nums.length; j ++){
                if(((nums[j] >> i) & 1) == 1){
                    sum += 1;
                }
                sum %= 3;
            }
            ans |= (sum << i);
            sum = 0;
        }
        
        return ans;
    }
}