class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        
        int prev = 0;
        for(int i = 0; i < s.length; i ++){
            if(s[i] == ' '){
                reverse(s, prev, i - 1);
                prev = i + 1;
            }
            else if(i == s.length - 1){
                reverse(s, prev, i);
            }
        }
    }
    
    private void reverse(char[] s, int a, int b){
        while(a < b){
            char temp = s[a];
            s[a] = s[b];
            s[b] = temp;
            a ++;
            b --;
        }
    }
}