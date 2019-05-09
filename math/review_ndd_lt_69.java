class Solution {
    public int mySqrt(int x) {
        long c = x;
        while (c * c > x){
            c = (c * c + x) / (2 * c);
        }
        return (int) c;
    }
}

// The power of math, it is called newton method.
// I got the intuition of it. Nooooo proof : )
// solving X^2 == a => x^2 - a == 0
// Xn+1 = Xn - (Xn^2 - a) / (2Xn) Easier to remember, could simplify
