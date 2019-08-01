class Solution {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int val1, val2;
        val1 = val2 = 0;
        int carry = 0;
        int sum = 0;
        String ans = "";
        
        while(p1 >= 0 || p2 >= 0){
            val1 = p1 >= 0? a.charAt(p1) - '0': 0;
            val2 = p2 >= 0? b.charAt(p2) - '0': 0;
            sum = val1 + val2 + carry;
            carry = sum >> 1;
            sum = sum & 1;
            ans = (sum == 1? "1": "0") + ans;
            p1 --;
            p2 --;
        }
        
        ans = (carry == 1? "1": "") + ans;
        return ans;
    }
}