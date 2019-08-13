class Solution {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(p1 >= 0 || p2 >= 0){
            int d1 = p1 >= 0? num1.charAt(p1) - '0': 0;
            int d2 = p2 >= 0? num2.charAt(p2) - '0': 0;
            int sum = (d1 + d2 + carry) % 10;
            carry = (d1 + d2 + carry) / 10;
            sb.append(sum);
            p1 --;
            p2 --;
        }
        
        if(carry == 1){
            sb.append(carry);
        }
        
        return sb.reverse().toString();
    }
}