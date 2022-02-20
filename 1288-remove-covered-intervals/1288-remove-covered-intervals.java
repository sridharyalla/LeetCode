class Solution {
    
    /***
    [[1,4],[3,6],[2,8]]
    [1,4],[2,8],[3,6],]
    
    
    [[1,2],[1,4],[3,4]]
    
    
    **/
    public int removeCoveredIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] interval: intervals)
            pq.add(interval);
        
        int ans =1;
        int left =pq.peek()[0];
        int right = pq.poll()[1];
        while (!pq.isEmpty()){
            int[] current = pq.poll();
            if( left<=current[0]  &&  current[1] <= right){
                continue;
            } else if ( left == current[0] && current[1] > right){
                right = current[1];
            } else {
                ans++;
                left = current[0];
                right =  current[1];
            }
        }
        return ans;
    }
}