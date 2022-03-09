class Solution {
    /**
      s   e   a
    s 0   1.  2     
    e 1   0   1  
    a 2   1.  1
    
       0  d   o  g
    0  0. 1   2  3
    f  1  1   2  3    
    r  2  2.  2  3
    o  3  3   2. 2
    g  4  4.  2. 2
    **/
    public int minDistance(String word1, String word2) {
        int m = word1.length()+1, n = word2.length()+1;
        int[][] dp = new int[m][n];

        for(int i =0 ; i < m; i++){
            for(int j=0; j < n; j++){
                if( i == 0){
                    dp[0][j] = j;
                } else if ( j ==0) {
                    dp[i][0] = i;
                } else if ( word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }

        return dp[m-1][n-1];
    }
}