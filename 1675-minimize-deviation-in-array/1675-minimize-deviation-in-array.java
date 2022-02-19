class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        int result = Integer.MAX_VALUE;
        for(int n : nums){
            if( n %2 != 0) {
                ts.add(2 * n);
            } else {
                ts.add( n);
            }
        }
        
        while ( ts.last() % 2 == 0){
            int f = ts.first();
            int l = ts.last();
            result = Math.min(result,l-f);
            ts.add(l/2);
            ts.remove(l);
        }
        
        return Math.min(result, ts.last() - ts.first());
    }
}