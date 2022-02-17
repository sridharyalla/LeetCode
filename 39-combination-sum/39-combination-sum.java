class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,0,target, new ArrayList<Integer>(), result);
        return result;
    }
    
    void backtrack(int[] candidates, int pos, int sum, int target, List<Integer> current, List<List<Integer>>  result) {
        if ( sum > target)
            return;
            
        if( sum == target){
            result.add(new ArrayList(current));
            return;
        }
        
        for(int i=pos; pos < candidates.length; pos++){
            current.add(candidates[pos]);
            backtrack(candidates,pos,sum+candidates[pos],target,current, result);
            current.remove(current.size()-1);
        }
            
        
    }
    
}