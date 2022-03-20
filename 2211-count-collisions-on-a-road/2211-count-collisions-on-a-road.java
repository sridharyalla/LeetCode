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
        for(char c : d.toCharArray()){
            if( c=='R'){
                r++;
            }else if( c == 'L'){
                count = count + (r);
                r=0;
            } else {
                count += r;
                r=0;
            }
        }
        int l=0;
        for(int i=d.length()-1; i>=0; i--){
            if( d.charAt(i)=='L'){
                l++;
            }else{
                count = count + l;
                l=0;
            }
        }        
        return count;
    }
}