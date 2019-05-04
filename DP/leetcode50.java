class Solution {
    public double myPow(double x, int n) {
        long n2 = n > 0 ? n : - (long)n;
        double ans = 1.0f;
        while(n2 != 0){
            if ((n2 & 1) == 1){
                ans *= x;
            }
            x *= x;
            n2 >>= 1;
        }
        return n > 0 ? ans : 1 / ans;

    }
}

// using the binary ops. For computation stuff, use binary operation.