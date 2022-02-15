class Solution {
    /**
    **/
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        for (int[] edge : dislikes){
            graph.computeIfAbsent(edge[0], v -> new ArrayList<Integer>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        boolean[] visited = new boolean[n];
        
        for(int j=0; j < n; j++){
            if( colors[j] == -1){
                colors[j] = 1;
                q.add(j+1);
                while(!q.isEmpty()){

                    int current = q.poll();
                    visited[current-1] = true;
                    List<Integer> neighbours = graph.get(current);

                    if( neighbours == null)
                        continue;

                    for(int neighbour : neighbours){
                        if( colors[neighbour-1] != -1 && colors[neighbour-1] == colors[current-1])
                            return false;
                        else {
                            colors[neighbour-1] = colors[current-1] == 1 ? 0 : 1;
                            if( !visited[neighbour-1])
                                q.add(neighbour);
                        }
                    }
                }
            } 
        }
        return true;
    }
}