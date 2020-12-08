package org.sridhar.leetcode;

public class GrumpyBookstoreOwner1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        for (int i=0;i < customers.length; i++) {
            if (grumpy[i] == 0 )
                sum += customers[i];
        }

        int maxSave = 0;
        int save = 0;
        int i=0;
        for (int j =0; j < customers.length; j++){
            if(j<X){
                if(grumpy[j]==1) {
                    save += customers[j];
                    maxSave = Math.max(maxSave,save);
                }
                continue;
            }
            if(grumpy[j]==1)
                save += customers[j];
            if(grumpy[i] == 1)
                save -=customers[i];
            i++;

            maxSave = Math.max(maxSave,save);
        }
        return sum + maxSave;
    }
}
