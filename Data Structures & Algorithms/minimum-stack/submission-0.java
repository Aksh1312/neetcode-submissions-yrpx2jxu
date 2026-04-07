class MinStack {
    Stack<Integer> stk;
    Stack<Integer> stk1;
    public MinStack() {
        stk=new Stack<>();
        stk1=new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(stk1.isEmpty()||val<=stk1.peek()){
            stk1.push(val);
        }
        else{
            stk1.push(stk1.peek());
        }
    }
    
    public void pop() {
        stk.pop();
        stk1.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return stk1.peek();
    }
}
