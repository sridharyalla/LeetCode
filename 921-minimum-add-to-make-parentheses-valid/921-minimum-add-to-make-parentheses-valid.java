class Solution {
    public int minAddToMakeValid(String s) {
     Stack<Character> stk = new Stack<>();
    
    int result =0;
    for( char c : s.toCharArray()){
      if( c == '(') {
        stk.push(c);
      } else if (c == ')') {
        if( stk.isEmpty()) {
          result++;
        } else {
          stk.pop();
        }
      }
    }
    
    if( stk.size()> 0){
      result += stk.size();
    }
    return result;       
    }
}