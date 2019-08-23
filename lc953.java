class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1){
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < order.length(); i ++){
            map.put(order.charAt(i), i);
        }
        
        for(int i = 1; i < words.length; i ++){
            String s1 = words[i - 1];
            String s2 = words[i];
            
            int p = 0;
            while(p < s1.length() && p < s2.length()){
                char c1 = s1.charAt(p);
                char c2 = s2.charAt(p);
                if(map.get(c1) > map.get(c2)){
                    return false;
                }
                else if(map.get(c1) < map.get(c2)){
                    break;
                }
                
                p ++;
            }
            
            if(p == s2.length() && p <= s1.length()){
                return false;
            }

        }
        
        return true;
    }
}