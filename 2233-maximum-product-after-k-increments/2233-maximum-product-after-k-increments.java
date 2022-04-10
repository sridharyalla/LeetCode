class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for(int n : nums){
            pq.add(n);
        }
        
        for(int i=0; i < k;i++){
            pq.add((pq.poll()+1));
        }
        
        long result =1;
        while(!pq.isEmpty()){
            result = (result * pq.poll()) % 1_000_000_007;
        }
        
        return (int)result;
    }
}