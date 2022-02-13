class Solution {
    
    
    // [42, 24]
    // [11, 11]
    // [1,  1]
    // [97, 79]
    
    // num[i]-num[j] = rev(num[i]) - rev(num[i])
    // num[i]-rev(num[j]) = num[j] - rev(num[j])
    public int countNicePairs(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for(int n : nums){
            int rev = rev(n);
            int val = map.getOrDefault(n-rev,0);
            map.put(n-rev , val+1);
            
            result = (result+val) % ((int)1e9 + 7);
        }
        return result;
    }
    
    int rev(int num){
        int r = 0;
        while( num > 0){
            r = r * 10 + (num %10);
            num /= 10;
        }
        return r;
    }
}