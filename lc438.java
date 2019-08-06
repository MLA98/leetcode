class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i ++){
            int count = map.getOrDefault(p.charAt(i), 0);
            map.put(p.charAt(i), count + 1);
        }
        
        int end = 0;
        int start = 0;
        int count = 0;
        
        List<Integer> ans = new LinkedList<>();
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                if(map.get(c) > 0){
                    count ++;
                }
                map.put(c, map.get(c) - 1);
            }
            
            while(count == p.length()){
                if(end - start + 1 == count){
                    ans.add(start);
                }
                
                c = s.charAt(start);
                
                if(map.containsKey(c)){
                    if(map.get(c) >= 0){
                        count --;
                    }
                    map.put(c, map.get(c) + 1);
                }
                
                start ++;
            }
                
                
            end ++;
        }
        
        return ans;
    }
}