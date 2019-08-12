// O(n^2) O(n) dp soultion Not optimal
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = true;
    
        for(int i = 0; i < nums.length; i ++){
            if(canReach[i]){
               for(int j = i + 1; j <= i + nums[i] && j < nums.length; j ++){
                   canReach[j] = true;
                   if(j == nums.length - 1){
                       return true;
                   }
               } 
            }
        }
        
        return canReach[nums.length - 1];
    }
}


// O(n) O(1) greedy soln.
class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i< nums.length; i ++){
            if(i > maxReach){
                return false;
            }
            
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if(maxReach > nums.length - 1){
                return true;
            }
        }
        
        return true;
    }
}