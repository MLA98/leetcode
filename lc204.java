class Solution {
    public int countPrimes(int n) {
        // sieve of Eratosthenes
        if(n < 2){
            return 0;
            }
        int maxPrime = (int)Math.sqrt(n);
        int count = 0;
        boolean[] isPrime = new boolean[n];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int j = 2; j < maxPrime + 1; j ++){
            if(!isPrime[j]){
                    for(int mul = j * j; mul < n; mul+=j) {
                        isPrime[mul] = true;
                    }
            }
        }
        
        for(boolean prime : isPrime) {
        if(!prime) {
            count++;
        }
    }   
        
        return count;
    }
}