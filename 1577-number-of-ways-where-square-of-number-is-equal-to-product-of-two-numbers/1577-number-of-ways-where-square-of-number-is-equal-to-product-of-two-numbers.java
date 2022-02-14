class Solution {
    /***
    nums2[i] *  nums2[i] == nums1[j] * nums1[k]
   
    **/
    public int numTriplets(int[] nums1, int[] nums2) {
        return count(nums1, nums2) + count(nums2, nums1);
    }
    
    int count(int[] nums1, int[] nums2) {
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        
        for(long n : nums1){
            map.put(n*n, map.getOrDefault(n * n,0)+1);
        }
            
        
        for(int i =0; i < nums2.length-1; i++){
            for(int j =i+1; j < nums2.length; j++){
                count +=map.getOrDefault(((long)nums2[i])* ((long)nums2[j]),0);
            }
        }
        
        return count;        
    }
}