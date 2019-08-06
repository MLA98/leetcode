// O(n) in time and space complexity

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Let's bug free it
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i]) <= k){
                    return true;
                }
            }
            
            map.put(nums[i], i);
        }
        
        return false;
    }
}

// O(n) in time but O(k) in space as the set only contains k elements.

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Let's bug free it
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i ++){
            if(i - k - 1 >= 0){
                set.remove(nums[i - k - 1]);
            }
            
            if(set.contains(nums[i])){
                return true;
            }
            
            set.add(nums[i]);
        }
        
        return false;
    }
}