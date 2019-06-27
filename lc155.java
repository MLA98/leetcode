// TWO stack
class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();  
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    
    public void pop() {
        int poped = stack.pop();
        if (poped == minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// One stack
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (x > min){
            stack.push(x);
        }
        else{
            stack.push(min);
            stack.push(x);
            min = x;
        }
    }
    
    public void pop() {
        if (min == stack.pop()){
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

// I have to admit it is a great method! brilliant!