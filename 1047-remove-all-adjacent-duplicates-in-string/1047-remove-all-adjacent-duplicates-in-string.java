class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i <s.length(); i++){
            if(stk.isEmpty()){
                stk.push(s.charAt(i));
            } else {
                if( stk.peek() == s.charAt(i)){
                    stk.pop();
                } else {
                    stk.push(s.charAt(i));
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.reverse().toString();
        
    }
}