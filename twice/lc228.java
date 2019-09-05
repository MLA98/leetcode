class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList<>();
        if(nums.length == 0){
            return ans;
        }
        
        
        int head = nums[0];
        int tail = nums[0];
        
        for(int i = 1; i < nums.length + 1; i ++){
            if(i < nums.length && nums[i] == nums[i - 1] + 1){
                tail = nums[i];
            }
            else{
                StringBuilder sb = new StringBuilder();
                if(head == tail){
                    sb.append(head);
                }
                else{
                    sb.append(head);
                    sb.append("->");
                    sb.append(tail);
                }
                ans.add(sb.toString());
                if(i < nums.length){
                    head = nums[i];
                    tail = nums[i];
                }
            }
        }
        
        return ans;
    }
}