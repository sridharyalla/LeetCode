class Solution {
    public int maximumCandies(int[] candies, long k) {
        int result = 0;
        
        int l =1, r = 0;
        for(int n : candies)
            r = Math.max(r,n);
        while ( l <= r){
            int mid = (l + r)/2;
            if( canAllocate(candies, k, mid)) {
                result = Math.max(result, mid);
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return result;
    }
    
    boolean canAllocate(int[] candies, long k, int c){
        long piles = 0;
        for(int i =0; i < candies.length; i++){
            piles += candies[i]/c;
        }
        return piles>=k;
    }
}