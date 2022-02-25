class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        if( v1.length < v2.length){
            return (compare(v2,v1) * -1);
        }
        return compare(v1,v2);
    }
    
    int compare(String[] v1, String[] v2) {
        
        for(int i=0; i < v1.length; i++){
            int p1 = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int p2 = i >= v2.length ? 0 : Integer.parseInt(v2[i]);
            if(p1 == p2){
                continue;
            } else if( p1 > p2){
                return 1;
            } else {
                return -1;
            }
        }
        
        return 0;
    }
}