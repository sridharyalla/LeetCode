class Solution {
    
    /**
    cczazcc
    zzcccca
    
    aababab
    bbbaaaa
    
    bbabaa
    **/
    public String repeatLimitedString(String s, int repeatLimit) {

        PriorityQueue<Character> q = new PriorityQueue<>(Comparator.reverseOrder());
        Stack<Character> extra = new Stack<>();
        for(char c : s.toCharArray()){
            q.add(c);
        }
        StringBuilder sb = new StringBuilder();

        char prev = q.poll();
        sb.append(prev);
        int count = 1;

        while(!q.isEmpty()){
            char c =  q.poll();
            if(prev == c && count < repeatLimit) {
                sb.append(c);
                count++;
            } else if (prev == c ) {
                extra.push(c);
            } else {
                if (!extra.isEmpty() && extra.peek() > c){
                    sb.append(c);
                    int popCount =0;
                    while (!extra.isEmpty() && extra.peek() > c && popCount < repeatLimit) {
                        q.add(extra.pop());
                        popCount++;
                    }
                } else {
                    sb.append(c);
                }
                prev = c;
                count=1;
            }
        }
        return sb.toString();
    }
}