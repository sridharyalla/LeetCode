class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // for(int i=0;i < arr.length;i++){
        //     if( arr[i]>arr[i+1])
        //         return i;
        // }
        // return arr.length-1;
        
        int l =0, r = arr.length-1;
        
        while (l < r){
            int mid = l+((r-l)/2);
            if( arr[mid] > arr[mid+1] && arr[mid-1] < arr[mid]){
                return mid;
            } else if( arr[mid]  < arr[mid+1]){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        
        return -1;
    }
}