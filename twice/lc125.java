class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if(length < 2){
            return true;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        s = s.toLowerCase();
        
        while(left < right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            boolean cont = false;
            
            if(!Character.isDigit(leftChar) && !Character.isLetter(leftChar)){
                cont = true;
                left ++;
            }
            
            if(!Character.isDigit(rightChar) && !Character.isLetter(rightChar)){
                cont = true;
                right --;
            }
            
            if(cont){
                continue;
            }
            
            if(leftChar != rightChar){
                return false;
            }
            
            left ++;
            right --;
        }
        
        return true;
    }
}