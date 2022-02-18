class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return bfs(arr,start);
        //return dfs(arr, start, visited);
    }
    
    boolean bfs( int[] arr, int pos) {
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.add(pos);
        
        while ( !q.isEmpty()){
            
            int node = q.poll();
            
            if( node < 0 || node >= arr.length)
                continue;
                        
            if(arr[node] == 0)
                return true;
            
            if( visited[node])
                continue;
            
            visited[node] = true;
            
            q.add(node + arr[node]);
            q.add(node - arr[node]);
        }
        
        return false;
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