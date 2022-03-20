class Solution {
    public int countCollisions(String d) {
        /**
        R L R S L L
        1 1 
        
        "L L R L R L L S L R L L S L SSSS"
               2   2 0 0 0   2
                                 1  
        **/
        
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