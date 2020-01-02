class Solution {
    private void addArray(int[] arr, int num, int index) {
        int addNum = num;
        while(addNum != 0) {
            int sum = addNum + arr[index];
            if(sum < 10) {
                arr[index] = sum;
                return;
            }
            else{
                arr[index] = sum % 10;
                addNum = 1;
                index --;
            }
        }
    }
    
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        int[] ansArray = new int[num1.length() + num2.length()];
                
        for(int i = num1.length() - 1; i >= 0; i --){
            for(int j = num2.length() - 1; j >= 0; j --){
                int index1 = num1.length() - i - 1;
                int index2 = num2.length() - j - 1;
                int arrayI = ansArray.length - 1 - (index1 + index2);
                
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                
                int product = n1 * n2;
                if(product >= 10) {
                    addArray(ansArray, product / 10, arrayI - 1);
                }
                
                addArray(ansArray, product % 10, arrayI);
            }
        }
        
        
        int start = 0;
        if(ansArray[0] == 0) {
            start = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < ansArray.length; i ++) {
            sb.append(ansArray[i]);
        }

        
        return sb.toString();
    }
}