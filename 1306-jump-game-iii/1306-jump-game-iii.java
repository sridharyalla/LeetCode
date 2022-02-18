class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    
    boolean dfs (int[] arr, int pos, boolean[] visited) {
        if( pos < 0 || pos >= arr.length)
            return false;
        
        if( arr[pos] == 0)
            return true;

        if( visited[pos])
            return false;
        
        visited[pos] = true;
        
        boolean ans  = dfs(arr, pos+arr[pos], visited) || dfs(arr, pos-arr[pos], visited);

        return ans;
    }
}