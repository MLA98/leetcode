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