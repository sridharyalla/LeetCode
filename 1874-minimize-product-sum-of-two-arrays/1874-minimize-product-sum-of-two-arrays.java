class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq1 = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue();
        for(int i=0; i< nums1.length;i++){
            pq1.add(nums1[i]);
            pq2.add(nums2[i]);
        }
        int minSum = 0;
        while(!pq1.isEmpty()){
            minSum += pq1.poll()  * pq2.poll();
        }
        return minSum;
    }
    
}