class Solution {
    int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max =0;
        int m = grid.length, n = grid[0].length;
        
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                if( grid[i][j] == 1){
                    int area = dfs(i,j,grid);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
    
    int dfs(int x, int y, int[][] grid){
        int area = 0;
        if(grid[x][y] == 1)
            area++;
        
        if( grid[x][y] == -1)
            return 0;
        grid[x][y] = -1;
        

        for(int i =0; i < dirs.length; i++){
            int x1 = x+dirs[i][0];
            int y1 = y+dirs[i][1];
            if((x1>=0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length) && grid[x1][y1] == 1)
                area = area + dfs(x1,y1,grid);
        }
        return area;
    }
}