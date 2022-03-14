class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stk= new LinkedList<>();
        
        for(String dir : dirs){
            if( dir.equals(".") || dir.equals("") ){
                continue;
            } else if ( dir.equals("..")){
                if (!stk.isEmpty()) {
                    stk.removeLast();
                }
                
            } else {
                stk.addLast(dir);
            }
        }
        StringBuilder out = new StringBuilder("");
        while( !stk.isEmpty()){
            out.append("/"+stk.removeFirst());
        }
        if(out.isEmpty())
            out.append('/');
        return out.toString();
    }
}