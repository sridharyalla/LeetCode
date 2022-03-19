class Solution {
    public int halveArray(int[] nums) {
        double sum = 0.0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n: nums){
            sum += n;
            pq.offer((double)n);
        }
        double target = sum/2;
        int result = 0;
        while( target > 0){
            double val = pq.poll()/2;
            target -= val;
            pq.offer(val);
            result++;
        }
        return result;
    }
}