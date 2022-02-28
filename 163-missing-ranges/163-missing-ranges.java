class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();

        if (nums == null || nums.length == 0){
            ans.add(formRange(lower,upper));
            return ans;
        }
        
        if( nums[0] > lower){
            ans.add(formRange(lower,nums[0]-1));
        }
        
        
        for(int i=0; i< nums.length-1; i++){
            if( nums[i+1] != nums[i] && nums[i+1] > nums[i] +1){
                ans.add( formRange(nums[i]+1 ,nums[i+1]-1));
            }
        }
        
        if( nums[nums.length-1] < upper){
            ans.add(formRange(nums[nums.length-1]+1,upper));
        }        
        return ans;
    }
    
    public String formRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}