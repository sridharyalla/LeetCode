class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        
        long sum = 0;
        for(int n : beans){
            sum += n;
        }
        
        long ans = Long.MAX_VALUE;
        long m = beans.length;
        for(int i=0; i < beans.length; i++){
            ans = Math.min(ans, sum - (m--) * beans[i]);
        }
        
        return ans;
        
    }
    
}