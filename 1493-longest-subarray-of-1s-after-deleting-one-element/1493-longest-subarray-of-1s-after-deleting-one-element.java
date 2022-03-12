class Solution {
    /**
    1, 1, 0, 1
    
    1  2  2  3
    3  2  1  1 
    **/
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i=0; i<n;i++){
            if(nums[i]==1){
                left[i] = (i==0 ? 0 : left[i-1])+1;
            } else {
                left[i] = 0;
            }
        }
        
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==1){
                right[i] = (i==n-1 ? 0 : right[i+1])+1;
            } else {
                right[i] = 0;
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n;i++){
            ans = Math.max((i==0? 0:left[i-1]) + (i==n-1? 0: right[i+1]), ans);
        }
        
        return ans;
    }
}