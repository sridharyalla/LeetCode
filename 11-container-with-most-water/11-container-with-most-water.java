class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, max = Integer.MIN_VALUE;
        while( l < r){
            int w = r - l;
            int h = Math.min(height[l], height[r]);
            max = Math.max(max, w * h);
            if( height[l] < height[r]){
                l++;
            } else if( height[l] > height[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }
        return max;
    }
}