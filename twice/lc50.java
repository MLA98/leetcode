// Naive O(n) solution.
// Time exceeds.
class Solution {
    public double myPow(double x, int n) {
        long n2 = n >= 0 ? (long) n: - (long) n;
        double ans = 1.0f;
        while(n2 != 0){
            ans *= x;
            n2 --;
        }
        return n > 0 ? ans : 1 / ans;
    }
}

// logn solution.
// It is brilliant that it shift the n each time to half
// the problem!
// n = 9 => 1001 
// Shifting...
//
// x^9 = ((x^2)^2)^2 * x ^ 1
// x stores x^n each time;
class Solution {
    public double myPow(double x, int n) {
        long n2 = n >= 0 ? (long) n: - (long) n;
        double ans = 1.0f;
        while(n2 != 0){
            if((n2 & 1) == 1){
                ans = ans * x;
            }
            x *= x;
            n2 >>= 1;
        }
        return n > 0 ? ans : 1 / ans;
    }
}