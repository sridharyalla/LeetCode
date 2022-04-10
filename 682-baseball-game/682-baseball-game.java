class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();
        
        int score = 0;
        for(String s : ops){
            if( s.equals("+")){
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
            } else if (s.equals("D")){
                list.add(list.get(list.size()-1) * 2);
            } else if (s.equals("C")) {
                list.remove(list.size()-1);
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        for(int n : list){
            score += n;
        }
        return score;
    }
}