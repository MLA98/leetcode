class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        restoreIp(s, ans, "", 0, 0);
        return ans;
    }
    
    private void restoreIp(String s, List<String> ans, String temp, int count, int index){
        
        if(count > 4){
            return;
        }
        
        if(index == s.length() && count == 4){
            ans.add(temp);
            return;
        }
        
        for(int i = 1 + index; i < 4 + index && i <= s.length(); i ++){
 
            String sub = s.substring(index, i);
            if(Integer.parseInt(sub) > 255 ||
              (sub.charAt(0) == '0' && sub.length() > 1)){
                continue;
            }
            
            restoreIp(s, ans, temp + sub + (count == 3? "": "."), count + 1, i);
        }
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        
        for(int i = 1; i < 4 && i < len - 2; i ++){
            for(int j = i + 1; j < i + 4 && i < len - 1; j ++){
                for(int k = j + 1; k < len && k < j + 4; k ++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        
        return ans;
    }
    
    private boolean isValid(String sub){
        if(sub == "" || sub.length() > 3 || Integer.parseInt(sub) > 255 || sub.charAt(0) == '0' && sub.length() > 1){
            return false;
        }
        
        return true;
    }
}