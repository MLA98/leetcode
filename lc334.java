class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for(int n: nums){
            if(n <= firstMin){
                firstMin = n;
            }
            else if(n <= secondMin){
                // the doublet is found
                secondMin = n;
            }
            else{
                // the triplet is found
                return true;
            }
        }
        
        return false;
    }
}