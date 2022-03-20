class Solution {
    public int countCollisions(String d) {
        int r=0;
        int count =0;
        char[] s = d.toCharArray();
        for(int i=0; i< s.length; i++){
            if( s[i]=='R'){
                r++;
            }else if( s[i] == 'L'){
                count = count + (r);
                r=0;
            } else {
                count += r;
                r=0;
            }
        }
        int l=0;
        for(int i=d.length()-1; i>=0; i--){
            if( s[i]=='L'){
                l++;
            }else{
                count = count + l;
                l=0;
            }
        }        
        return count;
    }
}