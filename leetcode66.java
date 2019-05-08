class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0){
            return digits;
        }

        int plus = digits.length - 1;
        while (true){
            if (digits[plus] + 1 != 10){
                digits[plus] = digits[plus] + 1;
                break;
            }
            else{
                if (plus == 0){
                    digits[plus] = 0;
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    return ans;
                }
                digits[plus] = 0;
                plus --;
            }
        }
        return digits;
    }
}

// easy peesi. Could make this better-looking.
