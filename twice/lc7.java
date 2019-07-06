class Solution {
    public int reverse(int x) {
        long ans = 0;
        int sign = x >= 0? 1 : -1;
        long x2 = x >= 0? (long) x: (long) -x;
        while(x2 > 0){
            ans *= 10;
            ans += x2 % 10;
            x2 /= 10;
        }
        ans = sign == 1 ? ans : -ans;
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int) ans;
    }
}

class Solution {
    public int reverse(int x) {
        int ans = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int adding;
        
        while(x != 0){
            adding = x % 10;
            if(ans > max / 10 
               || ans < min / 10
               || (ans == max / 10 && adding > (max % 10))
                || (ans == min / 10 && adding < (min % 10))){
                return 0;
            }
            
            ans *= 10;
            ans += x % 10;
            x /= 10;
        }

        return ans;
    }
}