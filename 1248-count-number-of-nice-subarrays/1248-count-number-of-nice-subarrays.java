class Solution {
    
    /**
      0. 1. 2. 3. 4
    [ 1, 1, 2, 1, 1]
    **/
    public int numberOfSubarrays(int[] nums, int k) {    
        
        int i=0; 
        int n = nums.length;
        int result =0;  // 0
        int odds = 0;  // 0
        int count =0;
        for(int j=0; j<n;j++){ // 0
            
            if(nums[j]%2 != 0){
                odds++;   // odds =3
                count=0;
            }
                
            
            while(k==odds){ //
                if(nums[i] %2 != 0){
                    odds--; 
                }
                count++;
                i++;
            }
            result += count;
        }
        
        return result;
    }
}