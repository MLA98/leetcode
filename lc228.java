class Solution {
    // This should be the medium?
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length == 0){
            return ans;
        }
        int prev = nums[0];
        int left = nums[0];
        
        for(int i = 1; i< nums.length; i ++){
            if(nums[i] != prev + 1){
                StringBuilder sb = new StringBuilder();
                if(prev == left){
                    sb.append(left);
                }
                else{
                    sb.append(left);
                    sb.append("->");
                    sb.append(prev);
                }
                ans.add(sb.toString());
                left = nums[i];
                prev = nums[i];
            }
            else{
                prev = nums[i];
            }
        }
        StringBuilder sb = new StringBuilder();
                if(prev == left){
                    sb.append(left);
                }
                else{
                    sb.append(left);
                    sb.append("->");
                    sb.append(prev);
                }
                ans.add(sb.toString());
        return ans;
    }
}