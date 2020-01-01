class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        
        while(indexA >= 0 || indexB >= 0){
            int valA = indexA >= 0 ? a.charAt(indexA) - '0' : 0;
            int valB = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            
            int sum = valA + valB + carry;
            if(sum == 0){
                sb.append(0);
            }
            else if(sum == 1){
                sb.append(1);
                carry = 0;
            }
            else if(sum == 2) {
                sb.append(0);
                carry = 1;
            }
            else if(sum == 3) {
                sb.append(1);
                carry = 1;
            }
            
            indexA --;
            indexB --;
        }
        
        if(carry == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
}