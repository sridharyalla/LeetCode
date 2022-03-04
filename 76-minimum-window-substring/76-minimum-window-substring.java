class Solution {
    public String minWindow(String s, String t) {
        if( t.length()> s.length())
            return "";

        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int minSize=Integer.MAX_VALUE;
        String result = "";
        int matchedChars = 0, i=0;
        for(int j=0; j< s.length(); j++){

            if (map.containsKey(s.charAt(j))){
                int val = map.get(s.charAt(j))-1;
                map.put(s.charAt(j),val);
                if( val >= 0){
                    matchedChars++;
                }


                while(matchedChars == t.length() ){
                    int size = j-i+1;
                    if( size < minSize){
                        minSize = size;
                        result = s.substring(i, i+size);
                    }


                    if(map.containsKey(s.charAt(i))){
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                        if(map.get(s.charAt(i)) > 0){
                            matchedChars --;
                        }
                    }


                    i++;
                }
            }
        }
        return result;

    }
}