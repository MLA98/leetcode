// O(T + P)*2^(T + P) time and spacee

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()){
            return text.isEmpty();
        }
        
        boolean firstMatch = !text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || 
                            pattern.charAt(0) == '.');
        
        if(pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return isMatch(text, pattern.substring(2)) ||
                (firstMatch && isMatch(text.substring(1), pattern));
        }
        else{
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}

// O(MN) space/ time complexity
class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean dp[][] = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        
        for(int i = 2; i < pattern.length() + 1; i += 2){
            if(pattern.charAt(i - 1) == '*' && dp[0][i - 2]){
                dp[0][i] = true;
            }
        }
        
        for(int i = 1; i <= text.length(); i ++){
            for(int j = 1; j <= pattern.length(); j ++){
                char c1 = text.charAt(i - 1);
                char c2 = pattern.charAt(j - 1);
                if(c1 == c2 || c2 == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(c2 == '*'){
                    if(pattern.charAt(j - 2) != c1 && 
                      pattern.charAt(j - 2)  != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }
                    else{
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[text.length()][pattern.length()];
    }
}