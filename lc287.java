// Convert the array to a list(not really but in idea)
// O(n) + O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        
        
        // they will eventually meet as
        // there is a cycle
        do{
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while(fast != slow);
        
        fast = nums[0];
        
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return fast;
    }
}

// O(n) time O(n) space soln
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        
        return - 1;
    }
}

// O(nlogn)/ O(1) space 
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length < 2){
            return -1;
        }
        
        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == nums[i - 1]){
                return nums[i];
            }
        }
        
        return - 1;
    }
}