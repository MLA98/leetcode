
class Solution {
    public int lengthLongestPath(String input) {
        if(input.length() == 0){
            return 0;
        }

        
        Stack<Integer> stack = new Stack();
        int max = 0;
        String[] split = input.split("\n");
        int preDepth = -1;
        
        
        for(int i = 0; i < split.length; i ++){
            String curr = split[i].replaceAll("\t", "");
            int currDepth = split[i].length() - curr.length();
            
            if(currDepth > preDepth){
                preDepth = currDepth;
                int topVal = stack.isEmpty() ? 0: stack.peek();
                stack.push(curr.length() + topVal);
            }
            else{
                int popDepth = preDepth - currDepth + 1;
                preDepth = currDepth;
                if(curr.contains(".")){
                    max = Math.max(max, stack.pop() + stack.size());
                }
                else{
                    stack.pop();
                }
                for(int j = 0; j < popDepth - 1; j ++){
                    stack.pop();
                }
                int topVal = stack.isEmpty() ? 0: stack.peek();
                stack.push(curr.length() + topVal);
            }
        }
        
        if(split[split.length - 1].contains(".")){
            max = Math.max(max, stack.pop() + stack.size());
        }
        
        return max;
    }
}