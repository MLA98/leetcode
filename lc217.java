class Solution {
    // public boolean containsDuplicate(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i: nums){
    //         if(set.contains(i)){
    //             return true;
    //         }
    //         set.add(i);
    //     }
    //     return false;
    // }
    
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        Integer prev = null;
        for(int i: nums){
            if(prev == null || prev != i){
                prev = i;
            }
            else if(prev == i){
                return true;
            }
        }
        return false;
    }
}