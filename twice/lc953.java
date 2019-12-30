class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length < 2){
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i ++){
            map.put(order.charAt(i), i);
        }
        
        
        for(int i = 1; i < words.length; i ++){
            int prevLength = words[i - 1].length();
            int nextLength = words[i].length();
            
            int travLength = Math.min(prevLength, nextLength);
            
            for(int j = 0; j < travLength; j ++){
                char prevChar = words[i - 1].charAt(j);
                char nextChar = words[i].charAt(j);
                if(map.get(prevChar) > map.get(nextChar)){
                    return false;
                }
                
                if(map.get(prevChar) < map.get(nextChar)){
                    break;
                }
                
                if (j == travLength - 1){
                    if(prevLength > nextLength){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}