class Solution {
    /**
    a a b d c d b c
    1 2 2 2 2 2 2 2
    0 0 1 1 1 1 2 2
    
    a a b b
    1 2 2 2
    0 0 1 2
    
    ab
    
    **/
    public long maximumSubsequenceCount(String text, String pattern) {
        return Math.max(helper(pattern.charAt(0)+text,pattern), helper(text+pattern.charAt(1),pattern));
    }
    
    public long helper(String text, String pattern) {
        long[] count = new long[text.length()];
        for(int i =0 ; i< text.length(); i++){
            if(text.charAt(i) == pattern.charAt(0)){
                count[i] = i==0 ? 1 : count[i-1]+1;
            } else {
                count[i] = i==0 ? 0 : count[i-1];
            }
        }
        long ans =0;
        boolean first = true;
        for(int i=0; i < text.length();i++){
            if( text.charAt(i) == pattern.charAt(1)){
                if( pattern.charAt(0) == pattern.charAt(1) ){
                    ans += (count[i]-1);
                }else {
                    ans += count[i];                    
                }

            }
        }
        return ans;
    }    
}