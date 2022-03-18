class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int c = 0;
        for(int n : nums){
            if(  n == target)
                c++;
        }
        return c > nums.length/2;
    }
}