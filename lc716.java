// O(n) for popMax() O(1) for rest of the operations.
class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack();
    Stack<Integer> maxStack = new Stack();
    public MaxStack() {
        
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        Stack<Integer> buffer = new Stack();
        int max = maxStack.peek();
        while(top() != max){
            buffer.push(pop());
        }
        pop();
        while(!buffer.empty()){
            push(buffer.pop());
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */