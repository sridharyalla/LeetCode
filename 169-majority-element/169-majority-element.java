class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;
        for ( int x : nums) {
            if ( ans == x){
                count ++;
            } else {
                count --;
            }
            if (count < 0){
                ans = x;
                count++;
            }
        }
        
        return ans;
    }
}