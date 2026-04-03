class FreqStack {
    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        this.freqMap = new HashMap<>();
        this.group = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        int updatedFreq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, updatedFreq);
        group.putIfAbsent(updatedFreq, new Stack<>());
        group.get(updatedFreq).push(val);
        maxFreq = Math.max(maxFreq, updatedFreq);
    }
    
    public int pop() {
        int val = group.get(maxFreq).pop();
        freqMap.put(val, freqMap.get(val) - 1);

        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */