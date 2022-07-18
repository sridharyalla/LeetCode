class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int ans = -1;
        
        for(int n : nums){
            int sum =0; 
            int t = n;
            while(t >0){
                sum += (t%10);
                t /= 10;
            }
            if( map.containsKey(sum)){
                ans = Math.max(ans,map.get(sum)+n);
                map.put(sum,Math.max(map.get(sum),n));
            } else {
                map.put(sum,n);
            }
        }
        return ans;
    }
}