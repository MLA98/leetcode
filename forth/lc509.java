class Solution {
    public int fib(int N) {
        if(N < 2){
            return N;
        }
        
        int f0 = 0;
        int f1 = 1;
        
        for(int i = 0; i < N - 1; i ++) {
            int temp = f0;
            f0 = f1;
            f1 += temp;
        }
        
        return f1;
    }
}