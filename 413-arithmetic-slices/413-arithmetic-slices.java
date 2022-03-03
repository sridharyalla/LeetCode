class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        if ( nums.length <2){
            return 0;
        }
        /***
        1, 2, 3, 4
        0  0  1  2
        
        [1,2,3,4,5,6]
         0 0 1 2 6,
        **/
        int result =0;
        for(int i =2; i < nums.length; i++){
            if( nums[i]-nums[i-1] == nums[i-1] - nums[i-2]){
                dp[i] = dp[i-1]+1;
                result += dp[i];
            }
            
        }
        
        return result;
    }
}