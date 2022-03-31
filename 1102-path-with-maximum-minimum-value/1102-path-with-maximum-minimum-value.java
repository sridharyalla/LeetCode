class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0, -1}};
    
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new PriorityQueue<>((a,b ) -> {
            return Integer.compare(grid[b[0]][b[1]], grid[a[0]][a[1]]);
        });
        
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        
        int ans = grid[0][0];
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            ans = Math.min(grid[current[0]][current[1]], ans);
            
            if(current[0] == (m-1) && current[1] == (n-1)){
                return ans;
            }
            
            for(int[] dir : dirs){
                int x  = current[0] + dir[0];
                int y  = current[1] + dir[1];
                
                if( x >=0 && y >=0 && x < m && y < n && !visited[x][y]) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        
        return -1;
        
    }
}