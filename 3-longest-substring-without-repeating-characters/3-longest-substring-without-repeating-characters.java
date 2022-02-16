class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> chars = new HashSet<>();
        
        char[] str = s.toCharArray();
        int i=0, j=0, max=0;
        
        while ( j< str.length){
            
            if(!chars.contains(str[j])){
                //expand the window
                chars.add(str[j]);
                j++;
                max = Math.max(max, j-i);
            } else {
                //shrink the window
                chars.remove(str[i]);
                i++;
            }
        }
        
        return max;
    }
}