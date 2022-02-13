class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    void backtrack(int[] nums, int pos, List<Integer> current, List<List<Integer>> result){      
        result.add(new ArrayList<Integer>(current));
        
        if (current.size() == nums.length)
            return;        
        
        for(int i=pos; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(nums,i+1,current,result);
            current.remove(current.size()-1);
        }
    }
}