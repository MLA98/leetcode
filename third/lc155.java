class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        min = Integer.MAX_VALUE;
    }
    
    // Consider duplicated number!
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            stack.push(x);
            min = x;
        }
        else{
            stack.push(x);
        }
    }
    
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */