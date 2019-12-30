class Solution {
    private boolean isPali(String s){
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            
            left ++;
            right --;
        }
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return isPali(s.substring(left, right)) || isPali(s.substring(left + 1, right + 1));
            }
            
            left ++;
            right --;
        }
        
        return true;
    }
}