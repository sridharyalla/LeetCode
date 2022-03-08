class Solution {
    /**
    0 -> [3,4]
    1 -> [3]
    2 -> [4,7]
    3 -> [5,6,7]
    4 -> [6]
    5 -> []
    6 -> []
    7 -> []
    
    
    **/
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        List<Set<Integer>>  result = new ArrayList<>();

        for(int i =0 ;i < n;i++){
            graph.computeIfAbsent(i, v-> new HashSet<Integer>());
            result.add(new TreeSet<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n ;i++){
            if( indegree[i] == 0)
                q.add(i);
        }
        

        while( !q.isEmpty()){
            int current = q.poll();
             
            for(int neighbour : graph.get(current)){
                result.get(neighbour).add(current);
                result.get(neighbour).addAll(result.get(current));
                indegree[neighbour]--;
                if( indegree[neighbour] == 0){
                    q.add(neighbour);
                }
                
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i < n; i++){
            ans.add(new ArrayList<Integer>(result.get(i)));
        }
        return ans;
    }
    
}