class Solution {
    /**
    7 - > 2 4 6
    8 ->  2 4 6
    9 ->  2 4 6 8
    10 -> 2 4 6 8
    11 -> 2 4 6 8 11
    12 ->         11
    15 ->         11 13 
    **/
    public int countEven(int num) {
        
        int count = 0, num1 = num;
        for (int i =2; i <= num; i++){
            int sum =0;
            int t = i;
            while( t > 0) {
                sum += (t%10);
                t /= 10;
            }
            if( sum %2 == 0)
                count++;
        }
        return count;
    }
}