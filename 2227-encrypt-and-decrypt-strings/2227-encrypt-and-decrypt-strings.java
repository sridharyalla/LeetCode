class Encrypter {
    
    Map<Character,String> keyMappings = new HashMap<>();
    Map<String,Integer> decodeCount = new HashMap<>();

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for(int i =0; i < keys.length; i++){
            keyMappings.put(keys[i], values[i]);
        }
        
        for(String s : dictionary) {
            String enc = encrypt(s);
            decodeCount.put(enc,decodeCount.getOrDefault(enc,0)+1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuffer sb = new StringBuffer();
        for(char c : word1.toCharArray()){
            sb.append(keyMappings.get(c));
        }
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return decodeCount.getOrDefault(word2,0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */