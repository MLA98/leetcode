class Solution {
    public int findNthDigit(int n) {
        List<Integer> nines = new ArrayList<>();
        int n_ = n;
        int range = 0;
        int cul = 0;
        if (n < 10){
            return n;
        }

        for (int i = 1; cul < Math.pow(2, 30); i ++){
            if (n_ - i * Math.pow(10, (i - 1)) * 9 > 0){
                n_ = n_ - i * (int) Math.pow(10, (i - 1));
                cul += i * Math.pow(10, (i - 1)) * 9;
            }
            else{
                range = i;
                break;
            }
        }
        
        int num = (int) Math.pow(10, (range - 1)) + (n - cul) / range;
        int num_index = (n - cul) % range;
        if (num_index == 0){
            num --;
            String number = String.valueOf(num);
            char[] digits = number.toCharArray();
            return digits[digits.length - 1] - '0';
        }
        String number = String.valueOf(num);
        char[] digits = number.toCharArray();
        return digits[num_index - 1] - '0';
    }
}

// This solution is quite shitty. Original and fast (beats double 100%) but not elegant.
