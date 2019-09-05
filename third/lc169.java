// 原创排序 有点垃圾
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == prev){
                count ++;
            }
            else{
                if(count > nums.length / 2){
                    return prev;
                }
                
                count = 1;
                prev = nums[i];
            }
        }
        
        return prev;
    }
}

// 因为大与1/2， 所以median必为众数
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        // 摩尔法：假设相同数字是属于一支军队
        // 每个士兵无差别攻击非相同军队士兵
        // 假设存在众数，最后留下的数字就是那个众数
        int major = 0;
        int count = 0;
        for(int num: nums){
            if(count == 0){
                major = num;
                count ++;
            }
            else if(major == num){
                count ++;
            }
            else{
                count --;
            }
        }
        return major;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int cand = 0;
        int count = 0;
        for(int n: nums){
            if(count == 0){
                cand = n;
                count ++;
            }
            else if(cand == n){
                count ++;
            }
            else{
                count --;
            }
        }
        
        return cand;
    }
}
