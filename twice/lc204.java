class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        int count = 0;
        
        for(int i = 2; i < (int)Math.sqrt(n) + 1; i ++){
            if(notPrime[i] == false){
                for(int j = 2; i * j < n; j ++){
                    notPrime[j * i] = true;
                }
            }
        }
                
        for(boolean not: notPrime){
            if(!not){
                count ++;
            }
        }
        
        return count;
    }
}