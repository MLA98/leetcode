class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        long reverse = 0;
        int x1 = x;
        
        while(x1 != 0){
            int digit = x1 % 10;
            x1 = x1 / 10;
            
            reverse *= 10;
            reverse += digit;
        }
        
        return reverse == x;
    }
}