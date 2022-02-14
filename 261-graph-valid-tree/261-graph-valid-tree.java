class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i =0; i < edges.length; i++){
            graph.computeIfAbsent(edges[i][0], v -> new HashSet<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], v -> new HashSet<>()).add(edges[i][0]);
        }
        
        return !hasCycle(0,-1, visited, graph) && visited.size() == n ;
    }
    
    boolean hasCycle(int node, int from, Set<Integer> visited, Map<Integer,Set<Integer>> graph){
        
        if(visited.contains(node))
            return true;
        
        visited.add(node);
        
        Set<Integer> neighbours = graph.get(node);
        
        if( neighbours == null)
            return false;
        
        for(int next : neighbours){
            if ( next != from && hasCycle(next,node, visited, graph))
                return true;
        }
        
        return false;
    }
}