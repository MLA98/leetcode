// Easy pee sy

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        if(numbers.length == 0){
            return ans;
        }
        
        int l = 0;
        int r = numbers.length - 1;
        
        while(l < r){
            if(target == numbers[l] + numbers[r]){
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            }
            else if(target > numbers[l] + numbers[r]){
                l ++;
            }
            else{
                r --;
            }
        }
        
        return ans;
    }
}