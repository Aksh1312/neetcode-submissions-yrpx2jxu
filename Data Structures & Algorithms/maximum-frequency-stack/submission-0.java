class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> map;
    int maxfreq=0;
    public FreqStack() {
        freq=new HashMap<>();
        map=new HashMap<>();
    }
    
    public void push(int val) {
        int n=freq.getOrDefault(val,0)+1;
        freq.put(val,n);
        if(n>maxfreq)maxfreq=n;
        map.computeIfAbsent(n,z->new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> stk=map.get(maxfreq);
        int val=stk.pop();
        freq.put(val,freq.get(val)-1);
        if(stk.isEmpty()){
            maxfreq--;
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