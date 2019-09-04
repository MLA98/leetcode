class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        // Easy hashmap thing????
        // It could definitely be done by hashmap but 
        // In case it is sorted array, something new 
        // is needed.
        
        // ==> Two-pointer method!
        int l = 0, r = numbers.length - 1;
        int sum = 0;
        // Since there is always an answer.
        while(r > l){
            sum = numbers[l] + numbers[r];
            if (sum == target){
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            }
            else if (sum > target){
                r--;
            }
            else{
                l ++;
            }
        }
        return ans;
    }
}