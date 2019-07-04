class Solution {
    public int calculate(String s) {
        int d = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++){
            if(arr[i] >= '0'){
                d = d * 10 - '0' + arr[i];
            }
            
            if(arr[i] < '0' && arr[i] != ' ' || i == arr.length - 1){
                if(sign == '+'){
                    stack.push(d);
                }
                if(sign == '-'){
                    stack.push(-d);
                }
                if(sign == '*'){
                    stack.push(stack.pop() * d);
                }
                if(sign == '/'){
                    stack.push(stack.pop() / d);
                }
                sign = arr[i];
                d = 0;
            }
        }
        int ans = 0;
        while(!stack.empty()){
            ans += stack.pop();
        }
        return ans;
    }
}