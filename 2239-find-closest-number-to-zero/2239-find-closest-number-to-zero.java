class Solution {
    public int findClosestNumber(int[] nums) {
        int ans=nums[0];
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            int t = Math.abs(n);
            if( t < min){
                ans = n;
                min = t;
            } else if( t == min && n > ans)
                ans = n;
        }
        
        return ans;
    }
}