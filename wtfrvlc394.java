class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack();
        Stack<StringBuilder> stringStack = new Stack();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        
        for(char ch: s.toCharArray()){
            if(ch == '['){
                numStack.push(k);
                stringStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            }
            else if(Character.isDigit(ch)){
                k *= 10;
                k += ch - '0';
            }
            else if(ch == ']'){
                StringBuilder tmp = curr;
                curr = stringStack.pop();
                for(int i = numStack.pop(); i > 0; i --){
                    curr.append(tmp);
                }
            }
            else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}