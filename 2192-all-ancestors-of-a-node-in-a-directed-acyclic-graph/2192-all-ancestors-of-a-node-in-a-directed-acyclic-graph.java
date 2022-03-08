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
        List<List<Integer>>  result = new ArrayList<>();

        for(int i =0 ;i < n;i++){
            graph.computeIfAbsent(i, v-> new HashSet<Integer>());
            result.add(new ArrayList<>());
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
                for(int p : result.get(current)){
                    if( !result.get(neighbour).contains(p)){
                        result.get(neighbour).add(p);
                    }
                }
                indegree[neighbour]--;
                if( indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        
        for(int i =0; i < n; i++){
            Collections.sort(result.get(i));
        }
        return result;
    }
    
}