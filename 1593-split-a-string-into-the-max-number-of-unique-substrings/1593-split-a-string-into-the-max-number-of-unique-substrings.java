class Solution {
    int res =0;
    public int maxUniqueSplit(String s) {
        HashSet<String> set = new HashSet<>();
        backtrack(s,0,set);
        return res;
    }

    void backtrack (String s, int pos, HashSet<String> set){
        if( pos >= s.length()){
            res= Math.max(res, set.size());
        }

        for(int i = pos; i < s.length(); i++) {
            String sp = s.substring(pos, i + 1);
            if (!set.contains(sp)) {
                set.add(sp);
                backtrack(s, i+1 , set);
                set.remove(sp);
            }
        }
    }
}