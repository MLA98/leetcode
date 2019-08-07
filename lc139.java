class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // As "" is always contained in the dict.
        
        for(int i = 1; i <= s.length(); i ++){
            for(int j = 0; j < i; j ++){
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}