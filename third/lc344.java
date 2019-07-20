class Solution {
    public void reverseString(char[] s) {
        // Is this too easy? One shot then
        int l = 0;
        int r = s.length - 1;
        while(r > l){
            char temp = s[r];
            s[r] = s[l];
            s[l] = temp;
            r --;
            l ++;
        }
    }
}