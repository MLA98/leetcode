class Solution {
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};
    private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five"
                                         , "Six", "Seven", "Eight", "Nine", "Ten",
                                        "Eleven", "Twelve", "Thirteen", "Fourteen",
                                        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                                        "Nineteen"};
    private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                                  "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        
        int i = 0;
        String ans = "";
        
        while(num > 0){
            if(num % 1000 > 0){
                ans = helper(num % 1000) + thousands[i] + " " + ans;
            }
            
            num = num / 1000;
            i ++;
        }
        
        return ans.trim();
    }
    
    private String helper(int num){
        if(num == 0){
            return "";
        }
        else if(num < 20){
            return lessThan20[num] + " ";
        }
        else if(num < 100){
            return tens[num / 10] + " " + helper(num % 10);
        }
        else{
            return lessThan20[num / 100] + " " + "Hundred" + 
                " " + helper(num % 100);
        }
    }
}