class Solution {
    private List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new LinkedList<>();
        bt(s, new ArrayList<String>(), 0, ans);
        return ans;
    }
    
    private void bt(String s, List<String> temp, int start, List<String> ans) {
        if(temp.size() == 4) {
            if(start == s.length()){
                String address = "";
                for(int i = 0; i < 4; i ++) {
                    if(i == 3){
                        address = address + temp.get(i);
                    }
                    else{
                        address = address + temp.get(i) + ".";
                    }
                }
                ans.add(address);
            }
            
            return;
        }
        
        for(int i = 1; i <= 3 && start + i <= s.length(); i ++) {
            String sub = s.substring(start, start + i);
            int digit = Integer.valueOf(sub);
            if(sub.charAt(0) == '0' && sub.length() > 1){
                continue;
            }
            if(digit <= 255 && digit >= 0) {
                temp.add(sub);
                bt(s, temp, start + i, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
}