class Solution {
    
    /**
    0 1 2 3 4
    0 0 0 0 0
    
      2    -2
        3
    -2. 2
    
    -2 2 5 0 -2
    
    -2 0 
    
    **/
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        
        for(int[] update : updates){
            int s = update[0];
            int e = update[1];
            int d = update[2];
            
            diff[s] += d;
            
            if( e +1 < length)
                diff[e+1] -= d;
        }
        
        int sum =0;
        for(int i=0; i < length; i++){
            diff[i] += sum;
            sum = diff[i];
        }
        
        return diff;
    }
}