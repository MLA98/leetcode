class Solution {
    public boolean canJump(int[] nums) {
        // recursion trial
        if (nums.length == 1){
            return true;
        }
        else{
            for (int i = 1; i <= nums[0]; i ++){
                if (i > nums.length - 1){
                    break;
                }
                    if (canJump(Arrays.copyOfRange(nums, i, nums.length))){
                        return true;
                    }
            }
        }
        return false;
    }
}

// My recursive approach at first which is quite inefficient.  IN the interview, 
// I could come up with this at first, then I could do a mending by using DP approach.

enum Index {
    GOOD, BAD, UNKNOWN
}

class Solution {
    public boolean canJump(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[nums.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i --){
            for (int j = nums[i]; j >= 1; j --){
                if (i + j > nums.length - 1){
                    memo[i] = Index.GOOD;
                    break;
                }
                if (memo[i + j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        
        if (memo[0] == Index.GOOD){
            return true;
        }
        return false;
        
    }
    

}

// get it through looking up the answear. Did it myself. Intuitive and easy. Keep it up!