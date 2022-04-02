class Solution {
    public boolean validPalindrome(String s) {
        int i=0, j = s.length()-1;
        
        while(i <=j){
            if (s.charAt(i) != s.charAt(j))
                return isPolindrome(s,i+1,j) || isPolindrome(s,i,j-1);
            else {
                i++;
                j--;               
            }

        }
        return true;
    }
    
    boolean isPolindrome(String s, int start, int end){
        while ( start <= end){
            if( s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else 
                return false;
        }
        return true;
    }
}