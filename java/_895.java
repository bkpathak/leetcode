class FreqStack {
    
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> fqStack;
    int maxFreq = 0;
        
    public FreqStack() {
        map = new HashMap<>();
        fqStack = new HashMap<>();
    }
    
    public void push(int x) {
        int f = map.getOrDefault(x, 0) + 1;
        map.put(x, f);
        maxFreq = Math.max(maxFreq, f);
        
        if (!fqStack.containsKey(f)) {
            fqStack.put(f, new Stack<Integer>());
        }
        fqStack.get(f).add(x);
    }
    
    public int pop() {
        int x = fqStack.get(maxFreq).pop();
        map.put(x, maxFreq -1);
        if (fqStack.get(maxFreq).size() == 0) maxFreq --;
        return x;
    } 
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */