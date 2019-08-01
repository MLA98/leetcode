class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0"){
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        int p1 = 0;
        int p2 = 0;
            
            
        for(int i = m - 1; i >= 0; i --){
            for(int j = n - 1; j >= 0; j --){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                arr[i + j + 1] += d1 * d2;
            }
        }
        
        int carry = 0;
        for(int i = arr.length - 1; i >= 0; i --){
            int tmp = (arr[i] + carry) % 10;
            carry = (arr[i] + carry) / 10;
            arr[i] = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num: arr){
            sb.append(num);
        }
        
        while(sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.length() == 0? "0": sb.toString();
    }
}