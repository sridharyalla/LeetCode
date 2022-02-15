class Solution {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        
        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        
        return uf.connected;
        
    }
    
    
    class UnionFind {
        int[] parent;
        int connected;
        UnionFind(int n){
            parent = new int[n];
            connected = n;
            for(int i=0; i <n; i++){
                parent[i] = i;
            }
        }
        
        int find(int x) {
            int root = x;
            while(parent[x] != x){
                x = parent[x];
            }
            //compression
            while( x != root){
                int temp = parent[root];
                parent[root] = x;
                root = temp;
            }
            return x;
        }
        
        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            
            if( fx != fy){
                parent[fx] = fy;
                connected--;
            }
        }
    }
}