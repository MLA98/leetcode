class Solution {
    public int calculate(String s) {
        int number = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number *= 10;
                number += (ch - '0');
            }
            else if(ch == '+' || ch == '-'){
                result += sign * number;
                sign = ch == '+' ? 1: -1;
                number = 0;
            }
            else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            else if(ch == ')'){
                result += sign * number;
                number = 0;
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + prevSign * result;
            }
        }
        result += sign * number;
        return result;
    }
}