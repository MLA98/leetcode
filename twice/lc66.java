class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return digits;
        }
        List<Integer> ansList = new ArrayList<>();
        int carry = 1;
        
        for(int i = digits.length - 1; i >= 0; i --){
            if(carry + digits[i] >= 10){
                ansList.add(carry + digits[i] - 10);
                digits[i] = carry + digits[i] - 10;
                carry = 1;
            }
            else{
                ansList.add(carry + digits[i]);
                digits[i] = carry + digits[i];
                carry = 0;
                return digits;
            }
        }
        
        if(carry == 1){
            ansList.add(1);
        }
        
        int[] ans = new int[ansList.size()];
        
        for(int j = 0; j < ans.length; j ++){
            ans[j] = ansList.get(ansList.size() - j - 1);
        }
        
        return ans;
    }
}