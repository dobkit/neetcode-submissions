class MinStack {
    // encoded value stack
    Deque<Long> ms = new ArrayDeque<>();
    long curMin = 0;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (ms.isEmpty()) {
            ms.addFirst((long)val);
            curMin = val;
        }
        else {
            if (val >= curMin) ms.addFirst((long)val);
            else {
                long newValue = 2L*val - curMin;
                ms.addFirst(newValue);
                curMin = val;
            }
        }
        // push normal value when >= min, else encoded value
    }
    
    public void pop() {    
        long popValue = ms.peekFirst();
        if (popValue < curMin) {    
            curMin = 2L*curMin - popValue;
        }
        ms.removeFirst();
    }
    
    public int top() {
        long peekValue = ms.peekFirst();
        if (peekValue < curMin) return (int)curMin;
        else return (int)peekValue;
    }
    
    public int getMin() {
        return (int)curMin;
    }
}
