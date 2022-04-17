class Solution {
    /**
    []             [ ]
     total/cost1    total -
    **/
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if( cost1 > total && cost2 >total)
            return 1;
        
        int n = total/cost1;
        long ans = 0;
        for(int i = 0;i <=  n; i++){
            int t = total-(cost1*i);
            ans = ans + (t/cost2)+1; 

        }
        
        return ans;
    }
}