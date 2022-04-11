class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i < m; i++){
            result.add(new ArrayList<>());
        }
        
        while( k > 0){
            int prev = grid[m-1][n-1];
            for(int i =0; i < m; i++){
                for(int j =0; j < n; j++){
                    int temp = grid[i][j];
                    grid[i][j] = prev;
                    prev = temp;
                }
            }
            k--;
        }
        for(int i =0; i < m; i++){
            for(int j =0; j < n; j++){
                result.get(i).add(grid[i][j]);
            }
        }
        
        return result;
    }
}