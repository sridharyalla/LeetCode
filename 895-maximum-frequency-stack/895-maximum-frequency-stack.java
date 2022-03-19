class FreqStack {

    class Entry {
        int value;
        int count;
        int freq;
        
        Entry(int value, int count, int freq){
            this.value = value;
            this.count = count;
            this.freq = freq;
        }
    }
    /**
    5 7 5 7 4 5 
    
    5
    **/
    PriorityQueue<Entry> pq;
    int counter=0;
    HashMap<Integer,Integer> map;
    public FreqStack() {
        pq = new PriorityQueue<>((Entry e1, Entry e2) -> {
            if(e1.freq == e2.freq){
                return Integer.compare(e2.count,e1.count);
            }
            return Integer.compare(e2.freq,e1.freq);
        });
        map = new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        counter++;
        pq.offer(new Entry(val,counter,map.get(val)));
    }
    
    public int pop() {
        Entry e = pq.poll();
        map.put(e.value,map.get(e.value)-1);
        return e.value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */