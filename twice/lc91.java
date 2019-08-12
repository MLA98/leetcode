class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        dp[1] = 1;
        for(int i = 2; i < s.length() + 1; i ++){
            int val = Integer.parseInt(s.substring(i - 2, i));
            if(val >= 1 && val <= 26 && !s.substring(i - 2, i - 1).equals("0")){
                dp[i] += dp[i - 2];
            }
            
            if(!s.substring(i - 1, i).equals("0")){
                dp[i] += dp[i - 1];
            }
        }
        
        return dp[s.length()];
    }
}