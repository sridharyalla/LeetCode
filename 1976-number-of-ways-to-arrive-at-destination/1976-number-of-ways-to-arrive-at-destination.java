class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer,List<long[]>> graph = new HashMap<>();
        long mod=(int)1e9+7;
        
        for(int[] road : roads){
            graph.computeIfAbsent(road[0], v -> new ArrayList<long[]>()).add( new long[] {road[1],road[2]});
            graph.computeIfAbsent(road[1], v -> new ArrayList<long[]>()).add( new long[] {road[0],road[2]});
        }
        
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong( a -> a[1]));
        q.add(new long[] {0,0});
        
        long[] mins = new long[n];
        Arrays.fill(mins, Long.MAX_VALUE);
        long[] ways = new long[n];
        mins[0] = 0;
        ways[0] = 1;
        
        
        while( !q.isEmpty()){
            long[] current = q.poll();
            long sourceNode = current[0];
            long sourceNodeMinDist = current[1];
            
            List<long[]> neighbours = graph.get((int)sourceNode);
            if( neighbours == null)
                continue;
            
            for( long[] neighbour : neighbours) {
                long node = neighbour[0];
                long cost = neighbour[1];
                
                if( sourceNodeMinDist+cost < mins[(int)node]) {
                    mins[(int)node] = sourceNodeMinDist+cost;
                    ways[(int)node] = ways[(int)sourceNode];
                    q.add(new long[] {node, mins[(int)node]});
                } else if ( sourceNodeMinDist+cost  ==  mins[(int)node]) {
                    ways[(int)node] = (ways[(int)node]+ways[(int)sourceNode]) % mod;
                } 
            }
        }
        
        return ((int) (ways[n-1]));
    }
}