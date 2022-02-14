class Solution {
    
    /**
    
    1 2 2 
    3 8 2
    5 3 5
    
    **/
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][] {{-1,0}, {0,1}, {1,0}, {0, -1}};
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] minEfforts = new int[m][n];
        for(int i =0; i < m; i++){
            Arrays.fill(minEfforts[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        q.offer(new int[]{0,0,0});
        while (!q.isEmpty()){
            
            int[] current = q.poll();
            int dist = current[2];
            int x = current[0], y= current[1];
            
            if( dist > minEfforts[x][y])
                continue;
            if( x == m-1 && y == n-1)
                return dist;
            
            for(int i=0; i < 4; i++){
                int x1 = x + dirs[i][0];
                int y1 = y + dirs[i][1];
                
                if( x1 < 0 || y1 < 0 || x1 > m-1 || y1 > n-1  )
                    continue;
                int newDist = Math.max(dist, Math.abs(heights[x][y]-heights[x1][y1]));
                
                if( newDist < minEfforts[x1][y1]){
                    minEfforts[x1][y1] = newDist;
                    q.offer(new int[]{x1,y1,newDist});
                }
            }
        }
        
        return 0;
        
    }
}