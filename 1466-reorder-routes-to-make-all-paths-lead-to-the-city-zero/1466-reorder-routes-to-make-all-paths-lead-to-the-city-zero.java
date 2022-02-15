class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        
        for(int[] connection : connections){
            graph.computeIfAbsent(connection[0],v -> new ArrayList<>()).add(new int[]{connection[1],1});
            graph.computeIfAbsent(connection[1],v -> new ArrayList<>()).add(new int[] {connection[0],0});
        }
        
        HashSet<Integer> visited = new HashSet<>();
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited.add(0);
        
        while (!q.isEmpty()) {
            
            int current = q.poll();
            for(int[] neighbour : graph.get(current)) {
                if( visited.contains(neighbour[0]))
                    continue;
                if(neighbour[1] == 1)
                    result++;
                q.add(neighbour[0]);
                visited.add(neighbour[0]);
            }
        }
        
        return result;
    }
}