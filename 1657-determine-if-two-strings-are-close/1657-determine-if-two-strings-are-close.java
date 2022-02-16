class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Count the occurences in each word 
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        
        for(int c : word1.toCharArray()){
            w1[c-'a']++;
        }
        
        for(int c : word2.toCharArray()){
            w2[c-'a']++;
        }
        // check if char appears in one and doesn't appear in other
        for(int i =0; i < 26; i++){
            if( w1[i] >0 && w2[i]==0 || w2[i] >0 && w1[i]==0){
                return false;
            }
        }
        // Compare the occurances are same
        Arrays.sort(w1);
        Arrays.sort(w2);
        
        return Arrays.equals(w1,w2);
    }
}