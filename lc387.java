class Solution {
    public int firstUniqChar(String s) {
        // Easy shit Please one shot
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        
        for(int j = 0; j < s.length(); j ++){
            char c = s.charAt(j);
            if(map.get(c) == 1){
                return j;
            }
        }
        
        return -1;
    }
}