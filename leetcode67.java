class Solution {
    public String addBinary(String a, String b) {
        // Hec, seems there is a much easier way to do it.
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder st = new StringBuilder();
        while(i >= 0 || j >= 0){
            int sum = carry;
            if (i >= 0) sum = sum + a.charAt(i) - '0';
            if (j >= 0) sum = sum + b.charAt(j) - '0';
            i --;
            j --;
            st.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) st.append(carry);
        return st.reverse().toString();
    }
}

// I used some really inefficient method. This way is copied :) MUCH MORE CONCISE.
