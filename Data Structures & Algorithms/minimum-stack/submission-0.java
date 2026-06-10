class MinStack {
    // Pairs stack
    private Deque<List<Integer>> ms;
    public MinStack() {
        ms = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int currentMin = val;

        if (!ms.isEmpty()) {
            currentMin = Math.min(ms.peekFirst().get(1), val);
        }
        ms.addFirst(List.of(val, currentMin));
    }
    
    public void pop() {
        ms.removeFirst();
    }
    
    public int top() {
        return ms.peekFirst().get(0);
    }
    
    public int getMin() {
        return ms.peekFirst().get(1);
    }
}
