class Solution {
    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        
        int spaces = 0;
        String[] words = text.trim().split("\\ +");
        for(char c: chars){
            if ( c == ' '){
                spaces++;
            }
        }

        if( words.length == 1){
            sb.append(words[0]);
            for(int i =0; i < spaces; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }
        int wordSpace = spaces/(words.length-1);
        
        int rr = 0;
        for( int j =0; j < words.length; j++){
            sb.append(words[j]);
            int r =0;
            for(int i=0; j<words.length-1 && i < wordSpace; i++){
                sb.append(' ');
                rr++;
            }     
        }
        for(; rr < spaces; rr++){
                sb.append(' ');
        }
        return sb.toString();
    }
}