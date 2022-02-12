class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for(int i = heights.length-1; i >= 0; i--){
            if( max < heights[i]) {
                result.add(i);
            }
            max = Math.max(max, heights[i]);
        }
        int n = result.size();        
        int[] ans = new int[n];

        for(int i=0; i < ans.length; i++) {
            ans[i] = result.get(n-1-i);
        }
        
        return ans;
    }
}