class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // Oh my fucking lord.
        // Finding the common prefix!
        if (m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}