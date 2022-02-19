class Solution {
    
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        
        for(int[] connection : connections){
            uf.union(connection[0], connection[1]);
        }
        
        if ( uf.size == 1) {
            return 0;
        } else if ( (uf.size - 1) > uf.extra) {
            return -1;
        } else {
            return uf.size-1;
        }
    }
    
    class UnionFind {
        
        int[] parent;
        int size;
        int extra;
        
        UnionFind(int n){
            size = n;
            extra = 0;
            parent = new int[n];
            for(int i=0; i < n; i++)
                parent[i] = i;
        }
        
        int find(int x){
            if( parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            
            if( fx != fy){
                parent[fy] = fx;
                size--;
            } else {
                extra++;
            }
        }
    }
}