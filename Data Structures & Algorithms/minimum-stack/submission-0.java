class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MinStack() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    public void push(int val) {
        s1.push(val);
        if(s2.isEmpty() || val <= s2.peek()){
            s2.push(val);
        }
    }
    
    public void pop() {
        int val = 0;
        if(!s1.isEmpty()){
            val = s1.pop();
        }
        if(val == s2.peek()){
            s2.pop();
        }
    }
    
    public int top() {
        if(!s1.isEmpty()){
            return s1.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return -1;
    }
}
