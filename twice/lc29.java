// fast but violate the rule that we cannot do it with 64 bits

class Solution {
    public int divide(int dividend, int divisor) {
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long dividend_ = dividend > 0 ? dividend: - (long) dividend;
        long divisor_ = divisor > 0 ? divisor: - (long) divisor;
        long lans = 0;
        
        while(dividend_ >= divisor_){
            long count = 1;
            long temp = divisor_;
            while(temp <= dividend_){
                temp <<= 1;
                count <<= 1;
            }
            
            count >>= 1;
            temp >>= 1;
            lans += count;
            dividend_ -= temp;
        }
        
        int ans;
	    if (lans > Integer.MAX_VALUE){ //Handle overflow.
		    ans = (!neg) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	    } else {
		    ans = neg ? -(int)lans : (int)lans;
	    }
        
        return ans;
    }
}

// Standard soln but I have some confusions, why the heck
// the x has to be 0?
// java use complement in negative numbers.
class Solution {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        while (a - b >= 0) {
            int x = 0;
            
            while(a - (b << x << 1) >= 0){
                x ++;
            }
            
            res += 1 << (x);
            a -= b << (x);
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}