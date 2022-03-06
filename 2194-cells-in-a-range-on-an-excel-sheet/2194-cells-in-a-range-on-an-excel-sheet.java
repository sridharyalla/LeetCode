class Solution {
    public List<String> cellsInRange(String s) {
    
        List<String> result = new ArrayList<>();
        for(int i = (s.charAt(0)); i <= (s.charAt(3)); i++){
            for(int j = (s.charAt(1)-'0'); j <= (s.charAt(4)-'0'); j++){
                result.add("" + ((char) i) + j);
            }
        }
        
        return result;
    }
}