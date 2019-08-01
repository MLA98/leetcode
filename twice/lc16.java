class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int subTarget = 0;
        int closest = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length - 2; i ++){
            if(i == 0 || nums[i] != nums[i - 1]){
                left = i + 1;
                right = nums.length - 1;
                subTarget = target - nums[i];
                while(left < right){
                    int sum = nums[left] + nums[right];
                    if(Math.abs(closest - target) > Math.abs(sum - subTarget)){
                        closest = sum + nums[i];
                    }
                    if(sum - subTarget == 0){
                        return target;
                    }
                    else if(sum - subTarget > 0){
                        right --;
                    }
                    else{
                        left ++;
                    }
                }
            }
        }
        
        return closest;
    }
}