class Solution {
    public long[] sumOfThree(long num) {
        long a = num/3;
        
        for(long i=(a-3); i < (a +3); i++){
            if( ((3 * i) + 3) == num ){
                return new long[] {i, i+1, i+2};
            }
        }
        
        return new long[]{};
    }
}