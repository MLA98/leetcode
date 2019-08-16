// O(n) O(n) solution

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new LinkedList<>();
        for(int num: nums){
            set.add(num);
        }
        
        for(int i = 1; i <= nums.length; i ++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        
        return ans;
    }
}

// O(n) O(1) soln
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for(int i = 0; i < nums.length;){
            int index = i + 1;
            if(index != nums[i] && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
            else{
                i ++;
            }
        }
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != i + 1){
                ans.add(i + 1);
            }
        }
        
        return ans;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}