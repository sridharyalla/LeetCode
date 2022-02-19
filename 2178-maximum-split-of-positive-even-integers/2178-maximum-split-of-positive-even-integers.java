class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if( finalSum%2 != 0  )
            return new ArrayList<Long>();

        LinkedList<Long> set = new LinkedList<>();

        Set<Long> result = new HashSet<>();

        long i = 0;
        long sum =0;
        long f = finalSum;
        while( i <= finalSum){
            i += 2;
            set.add(i);
            finalSum -= i;
            sum += i;
        }

        long dif = sum -f;
        if( dif > 0)
            set.pollFirst();
        else {
            long temp = set.pollLast();
            set.remove(temp);
            set.add(temp+(-dif));
        }

        return new ArrayList<>(set);
    }
}