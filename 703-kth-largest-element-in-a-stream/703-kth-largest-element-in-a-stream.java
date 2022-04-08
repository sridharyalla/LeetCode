class KthLargest {


    PriorityQueue<Integer> pq;
    int k =0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;
        for(int n : nums)
            add(n);
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */