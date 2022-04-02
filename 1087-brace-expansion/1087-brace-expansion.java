class Solution {
    
    public String[] expand(String s) {
        List<String> input = new ArrayList<>();
        char[] str = s.toCharArray();
        boolean expand = false;
        String buffer = "";
        for(int i=0; i < s.length(); i++){
            if(str[i]== '{') {
                expand = true;
            } else if ( expand && str[i] >= 'a' &&  str[i]  <= 'z') {
                buffer += str[i] ;
            } else if(!expand && str[i]  >= 'a' &&  str[i]  <= 'z') {
                input.add(""+str[i] );
            } else if (str[i] == '}'){
                input.add(buffer);
                buffer = "";
                expand = false;
            }
        }
        Set<String> result = new TreeSet<>();
        StringBuffer sb = new StringBuffer();
        backtrack(result,0,sb,input);
        String[] ret = new String[result.size()];
        int pos =0;
        for(String r : result)
            ret[pos++] = r;
        return ret;
    }
    
    void backtrack(Set<String> result, int pos, StringBuffer sb, List<String> input) {
        String s = input.get(pos);
        for(int j =0; j < s.length(); j++){
            sb.append(s.charAt(j));
            if( pos == input.size()-1){
                result.add(sb.toString());
            } else 
                backtrack(result,pos+1,sb,input);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}