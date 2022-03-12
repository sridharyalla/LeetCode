class Solution {
    /**
    
    **/
    public int shipWithinDays(int[] weights, int days) {
        
        int n = weights.length;
        int r=0;
        int l = 0;
        for(int w : weights){
            r += w;
            l = Math.max(l,w);
        }
    
        
        while( l < r){
            int mid = l + (r-l)/2;
            
            int loaded = 0;
            int count = 1;
            for (int w: weights) {
                if (loaded + w > mid) {
                    count += 1;
                    loaded = 0;
                }
                loaded += w;
            }
            if( count > days){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        
        return l;
    }
}