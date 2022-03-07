class Solution {
    
    /**
     0 1 2 3 4 5 6 7 8 9
    [8,9,4,0,2,1,3,5,7,6]
    
    338 -> 007
    38  -> 07
    991 -> 669
    
    7 -> 338, 38
    669 -> 991
    
    338,38, 
    
    
    [9,8,7,6,5,4,3,2,1,0]
    [0,1,2,3,4,5,6,7,8,9]

    9 0
    8 1
    7 2
    6 3
    **/
    public int[] sortJumbled(int[] mapping, int[] nums) {
        
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        
        for(int n : nums){
            int t = n;
            int p = 1;
            int mappedNumber = 0;
            while( n > 0){
                mappedNumber = mappedNumber + (mapping[n%10] * p);
                p *= 10;
                n /= 10;
            }
            if( t == 0)
                mappedNumber = mapping[t%10];
            map.computeIfAbsent(mappedNumber, v -> new ArrayList<Integer>()).add(t);
        }
        
        int[] result = new int[nums.length];
        
        int pos =0;
        for(List<Integer> l : map.values()){
            for(int n: l){
                result[pos++] = n;
            }
        }
        
        return result;
    }
}