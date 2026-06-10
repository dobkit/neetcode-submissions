class MinStack {
    // two stack
    private Deque<Integer> valueStack = new ArrayDeque<>();
    private Deque<Integer> minValueStack = new ArrayDeque<>();
    
    public MinStack() {
    }
    
    public void push(int val) {
        valueStack.addFirst(val);

        if (minValueStack.isEmpty()) minValueStack.addFirst(val);
        else if (minValueStack.peekFirst() >= val) minValueStack.addFirst(val);
    }
    
    public void pop() {
        int popValue = valueStack.peekFirst();
        valueStack.removeFirst();
        
        if (popValue == minValueStack.peekFirst()) minValueStack.removeFirst();
    }
    
    public int top() {
        return valueStack.peekFirst();
    }
    
    public int getMin() {
        return minValueStack.peekFirst();
    }
}
