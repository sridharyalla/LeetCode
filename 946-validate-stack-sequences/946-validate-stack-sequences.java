class Solution {
    /**
    1,2,3,4,5
    
    4,5,3,2,1
    
    
    1
    
    **/
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack();
        int n = pushed.length;
        int i=1;
        stk.push(pushed[0]);
        for(int j=0; j < n; j++){
            
            while((stk.isEmpty()|| popped[j] != stk.peek()) && i < n){
                stk.push(pushed[i++]);
            }
            if(popped[j] ==stk.peek() ){
                stk.pop();
            }
        }
        
        return stk.isEmpty();
    }
}