class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<k-1; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        int ans =0;
        for(int i=k-1; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            if(map.keySet().size() == k)
                ans++;
            int c = map.get(s.charAt(i-k+1))-1;
            map.put(s.charAt(i-k+1),c);
            if( c == 0)
                map.remove(s.charAt(i-k+1));
        }
        
        return ans;
    }
}