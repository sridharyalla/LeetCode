class ATM {

    long[] notes = new long[5];
    int[] value = new int[] {20,50,100,200,500};
    
    public void deposit(int[] banknotesCount) {
        for(int i =0; i < banknotesCount.length; i++){
            notes[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        
        int[] ans = new int[5];
        for(int i=notes.length-1; i>=0; i--){
            if( notes[i]>0 && amount >= value[i]){
                long d = Math.min((amount/value[i]), notes[i]);
                ans[i] = (int)d;
                amount -= (d * value[i]);
            }
        }
        if( amount <= 0){
            for(int i=notes.length-1; i>=0; i--){
                notes[i] -= ans[i];
            }
            return ans;
        } else {
            return new int[] {-1};
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */