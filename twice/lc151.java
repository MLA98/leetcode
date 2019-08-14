// 标准答案
class Solution {
    public String reverseWords(String s) {
        String[] splited = s.trim().split("\\ ");
        StringBuilder sb = new StringBuilder();
        String prev = "";
        for(int i = splited.length - 1; i >= 0; i --){
            if(!splited[i].equals("")){
                sb.append(splited[i]);
                if(i != 0){
                    sb.append(" ");
                }
            }
        }
        
        return sb.toString();
    }
}

// Not ideal solution cuz I used two extra data structure and
// the time is some what O(n) as well
class Solution {
    public String reverseWords(String s) {
        char[] chArray = s.trim().toCharArray();
        reverse(0, chArray.length - 1, chArray);
        int a = 0;
        
        for(int b = 0; b < chArray.length; b ++){
            if(chArray.length - 1 == b){
                reverse(a, b, chArray);
            }
            else if(chArray[b] == ' '){
                reverse(a, b - 1, chArray);
                a = b + 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        char prev = 'a';
        for(char ch: chArray){
            if(ch == ' ' && prev != ' '){
                sb.append(' ');
            }
            else if(ch != ' '){
                sb.append(ch);
            }
            
            prev = ch;
        }
        
        
        return sb.toString();
    }
    
    private void reverse(int a, int b, char[] arr){
        while(a < b){
            char temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a ++;
            b --;
        }
    }
}