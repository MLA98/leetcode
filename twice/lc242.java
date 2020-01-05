class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c1 : sArr) {
            int count = map.getOrDefault(c1, 0);
            map.put(c1, count + 1);
        }
        
        for(char c1 : tArr) {
            int count = map.getOrDefault(c1, 0);
            if(count == 0) {
                return false;
            }
            
            map.put(c1, count - 1);
        }
        
        for(int c1 : map.values()) {
            if(c1 != 0){
                return false;
            }
        }
        
        return true;
    }
}