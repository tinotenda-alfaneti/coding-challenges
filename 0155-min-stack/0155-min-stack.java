class MinStack {
    
    PriorityQueue<Integer> minHeap;
    Stack<Integer> stack;

    public MinStack() {
        minHeap = new PriorityQueue<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minHeap.add(val);
    }
    
    public void pop() {
        int popped = stack.pop();
        if (minHeap.peek() == popped) {
            minHeap.remove();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        while(!stack.contains(minHeap.peek())) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */