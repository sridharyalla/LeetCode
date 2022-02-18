class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == 0)  return num;
        if(k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : num.toCharArray()){
            while( k > 0 && !stack.isEmpty() && stack.peek()> c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        while (k > 0 ){
            stack.pop();
            k--;
        }
        
        String ans = "";
        
        while( !stack.isEmpty()){
            ans = stack.pop() + ans;
        }
        
        while(ans.length() > 1 && ans.charAt(0) == '0'){
            ans = ans.substring(1);
        }
        return ans;
    }
}