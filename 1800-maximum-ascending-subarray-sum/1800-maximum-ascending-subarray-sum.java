class Solution {
    public int maxAscendingSum(int[] nums) {
        
        int sum = nums[0];
        int max = nums[0];
        
        for(int i =1; i < nums.length; i++){
            int currentSum = sum + nums[i];
            if( nums[i] <= nums[i-1]){
                currentSum = nums[i];
            }
            sum = currentSum;
            max = Math.max(max,currentSum);
        }
        
        return max;
    }
}