class Solution {
    /**
    "AAAA"
    
  (26*26*26 *1) + (26 * 26 * 1) + (26 *1) +1
    **/
    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int ans = 0;
        for(int i = chars.length-1; i >=0; i--){
            ans += Math.pow(26,(chars.length-1 -i)) * ((chars[i] -'A')+1);
        }
        return ans;
    }
}