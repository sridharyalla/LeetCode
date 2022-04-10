class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        
        for(int n : nums){
            pq.add((long)n);
        }
        
        for(int i=0; i < k;i++){
            pq.add((pq.poll()+1));
        }
        
        System.out.println(pq);
        long result =1;
        while(!pq.isEmpty()){
            result = (result * pq.poll()) % 1_000_000_007;
        }
        
        return (int)result;
    }
}