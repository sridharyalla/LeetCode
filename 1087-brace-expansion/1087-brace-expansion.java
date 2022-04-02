class Solution {
    
    public String[] expand(String s) {
        List<String> input = new ArrayList<>();
        boolean expand = false;
        String buffer = "";
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == '{') {
                expand = true;
            } else if ( expand && s.charAt(i) >= 'a' &&  s.charAt(i) <= 'z') {
                buffer += s.charAt(i);
            } else if(!expand && s.charAt(i) >= 'a' &&  s.charAt(i) <= 'z') {
                input.add(""+s.charAt(i));
            } else if (s.charAt(i) == '}'){
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