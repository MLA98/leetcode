class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        
        for(int ast : asteroids) {
            if(stack.isEmpty() || ast > 0){
                stack.push(ast);
            }
            else{
                boolean emptyAdd = true;
                while(!stack.isEmpty()){
                    int peek = stack.peek();
                    if(peek > 0) {
                        if(Math.abs(peek) == Math.abs(ast)) {
                            emptyAdd = false;
                            stack.pop();
                            break;
                        }
                        else if(Math.abs(peek) > Math.abs(ast)) {
                            break;
                        }
                        else {
                            stack.pop();
                        }
                    }
                    else{
                        stack.push(ast);
                        break;
                    }
                }
                
                if(stack.isEmpty() && emptyAdd) {
                    stack.push(ast);
                }
            }
        }
        
        int[] ans = new int[stack.size()];
        int index = stack.size() - 1;
        
        while(!stack.isEmpty()) {
            ans[index] = stack.pop();
            index --;
        }
        
        return ans;
    }
}