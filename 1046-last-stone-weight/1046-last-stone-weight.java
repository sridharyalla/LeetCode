class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones){
            q.offer(n);
        }
        
        while ( q.size() != 1) {
            int a = q.poll();
            int b = q.poll();
            q.offer(a-b);
        }
        
        return q.peek();
    }
}