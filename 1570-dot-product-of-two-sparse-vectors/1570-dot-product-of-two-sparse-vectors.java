class SparseVector {
    
    HashMap<Integer,Integer> vector = new HashMap<>();
    
    SparseVector(int[] nums) {
        for(int i =0; i < nums.length; i++){
            if( nums[i] != 0){
                vector.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum =0;
        
        for(Map.Entry<Integer,Integer> entry: vector.entrySet()){
            int p = vec.vector.getOrDefault(entry.getKey(), 0);
            sum += p * entry.getValue();
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);