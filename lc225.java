class MyStack {
    // One shot bug-free but we definitely have better solutions!
    // Tmr's task
    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        
        while(q2.size() > 1){
            q1.offer(q2.poll());
        }
        
        
        return q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        
        while(q2.size() > 1){
            q1.offer(q2.poll());
        }
        
        int val = q2.poll();
        
        q1.offer(val);
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */