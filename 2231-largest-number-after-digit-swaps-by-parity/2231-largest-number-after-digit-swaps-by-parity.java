class Solution {
    public int largestInteger(int num) {

        String s = ""+ num;
        
        int[] nstr = new int[s.length()];
        
        int p =0;
        for(char c: s.toCharArray()){
            nstr[p++] = c -'0';
        }
        
        for(int i =0; i < nstr.length; i++){
            int max = nstr[i];
            for(int j =i +1; j < nstr.length; j++){
                if( nstr[i] % 2  ==0 && nstr[j] %2 ==0 && nstr[j] > nstr[i]){
                    swap(nstr, i, j);
                } else if( nstr[i] % 2 !=0 && nstr[j] %2 !=0  && nstr[j] > nstr[i]){
                    swap(nstr, i, j);
                }
            }
        }
        
        int ans = 0;
        
        for(int i =0; i < nstr.length;i++){
            ans = (ans * 10) + nstr[i];
        }
        return ans;
    }
    
    void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}