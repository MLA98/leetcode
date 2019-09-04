// sb force
// O(m - n);
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = m;
        
        for(int i = m + 1; i <= n; i ++){
            ans &= i;
        }
        
        return ans;
    }
}

// Pattern soln.
// Bit's business Let's do it with bit then.
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int a = m;
        int b = n;
        int count = 0;
        // Pattern found
        while(a != b && a != 0){
            a = a >> 1;
            b = b >> 1;
            count ++;
        }
        
        return a << count;
    }
}