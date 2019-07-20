// SB force
class Solution {
    public int divide(int dividend, int divisor) {
        int ans = 0;
        while(dividend >= 0){
            dividend -= divisor;
            ans ++;
        }
        ans --;
        return ans;
    }
}

