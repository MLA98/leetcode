class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        char leftOp = '+';
        s = s + "+";
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            int toPush = 0;
            char tempOp = ' ';
            if(c == '+'){
                tempOp = '+';
            }
            else if(c == '-'){
                tempOp = '-';
            }
            else if(c == '*'){
                tempOp = '*';
            }
            else if(c == '/'){
                tempOp = '/';
            }
            else if(c == ' '){
                continue;
            }
            else{
                sb.append(c);
                continue;
            }
            
            if(leftOp == '+' || leftOp == '-'){
                toPush = leftOp == '-'
                    ? - Integer.parseInt(sb.toString()) 
                    : Integer.parseInt(sb.toString());
            }
            else if(leftOp == '*'){
                toPush = stack.pop() * Integer.parseInt(sb.toString());
            }
            else if(leftOp == '/'){
                toPush = stack.pop() / Integer.parseInt(sb.toString());
            }
            
            leftOp = tempOp;
            stack.push(toPush);
            sb = new StringBuilder();
        }
        
        int ans = 0;
        
        while(!stack.empty()){
            ans += stack.pop();
        }
        
        return ans;
    }
}