class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] pairs = new int[mat.length][2];
        
        for(int i =0; i < mat.length; i++) {
            int sum =0;
            for(int j=0; j < mat[0].length; j++){
                if( mat[i][j] == 1)
                    sum++;
            }
            pairs[i][0] = i;
            pairs[i][1] = sum;
        }
        
        Arrays.sort(pairs, ( int[] a, int[] b) -> {
            if(a[1] == b[1])
                return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        
        int[] result = new int[k];
        for(int i=0; i< k;i++){
            result[i] = pairs[i][0];
        }
        
        return result;
    }
}