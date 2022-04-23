class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;
        int i =0, j =0;
        
        for( ; j< s.length(); j++){
            if( isVovel(s.charAt(j))){
                count++;
            }
            if( j - i >= k){
                if( isVovel(s.charAt(i))){
                    count--;
                }
                i++;
            }
            max = Math.max(max,count);
        }
        
        return max;
    }
    
    boolean isVovel(char c){
        return c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u';
    }
}