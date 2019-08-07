// O(n) O(n) solution, quite inefficient.
// Of course, sort and do in O(1) space. 
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new LinkedList<>();
        
        for(int num: nums){
            if(set.contains(num)){
                ans.add(num);
            }
            else{
                set.add(num);
            }
        }
        
        return ans;
    }
}


// O(n) + O(1) solution 
// The core is to utilize the array's index to store some information
// in this case, we could make the element into negative one as all numbers in 
// the nums[] is positive, therefore, that could ba a good way to store info.
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i ++){
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if(nums[index] < 0){
                ans.add(num);
            }
            else{
                nums[index] = - nums[index];
            }
        }
        
        return ans;
    }
}