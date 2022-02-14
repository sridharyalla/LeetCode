class Solution {
    public int secondHighest(String s) {
        int max1 =-1, max2=-1;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int n  = (c - '0');
                if( n > max1) {
                    max2 = max1;
                    max1 = n;
                } else if( n > max2 && n < max1) {
                    max2 = n;
                }
            }
        }
        
        return max2;
    }
}