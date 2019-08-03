class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < t.length(); i ++){
            char c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        
        int shown = 0;
        int left = 0;
        int minLength = s.length() + 1;
        int minLeft = 0;
        
        
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0){
                    shown ++;
                }
            }
            
            while(shown == t.length()){
                if(minLength > i - left + 1){
                    minLength = i - left + 1;
                    minLeft = left;
                }
                c = s.charAt(left);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0){
                        shown --;
                    }
                }
                
                left ++;
            }
        }
        
        if(minLength == s.length() + 1){
            return "";
        }
        
        return s.substring(minLeft, minLeft + minLength);
    }
}