class Solution {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while(index1 >= 0 || index2 >= 0){
            int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sum %= 10;
            sb.append(sum);
            index1 --;
            index2 --;
        }
        
        if(carry == 1){
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}