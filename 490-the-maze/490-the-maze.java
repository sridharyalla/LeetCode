class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        
        int[][] dirs = new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        

        while(!q.isEmpty()){
            
            int[] current = q.poll();
            visited[current[0]][current[1]] = true;
            
            if( current[0] == destination[0] && current[1] == destination[1])
                return true;
            
            for(int i=0; i < 4; i++){
                int x=current[0], y=current[1];
                while( x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0){
                    x += dirs[i][0];
                    y += dirs[i][1];
                }
                
                x -= dirs[i][0];
                y -= dirs[i][1];
                if( !visited[x][y]){
                    q.offer(new int[]{x,y});
                    
                }
                
            }
            
        }
        
        return false;
    }
}