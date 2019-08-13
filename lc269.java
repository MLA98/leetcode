class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        buildGraph(words, map, inDegree);
        return bfs(map ,inDegree);
    }
    
    private void buildGraph(String[] words, Map<Character, Set<Character>> map, Map<Character, Integer> inDegree){
        for(String word: words){
            for(char ch: word.toCharArray()){
                map.putIfAbsent(ch, new HashSet<>());
                inDegree.putIfAbsent(ch, 0);
            }
        }
        
        for(int i = 1; i < words.length; i ++){
            String prevWord = words[i - 1];
            String currWord = words[i];
            int minLen = Math.min(prevWord.length(), currWord.length());
            for(int j = 0; j < minLen; j ++){
                char prevCh = prevWord.charAt(j);
                char currCh = currWord.charAt(j);
                if(prevCh != currCh){
                    if(!map.get(prevCh).contains(currCh)){
                        map.get(prevCh).add(currCh);
                        inDegree.put(currCh, inDegree.get(currCh) + 1);
                    }
                    
                    break;
                }
            }
        }
    }
    
    private String bfs(Map<Character, Set<Character>> map, Map<Character, Integer> inDegree){
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch: map.keySet()){
            if(inDegree.get(ch) == 0){
                q.offer(ch);
            }
        }
        
        while(!q.isEmpty()){
            char ch = q.poll();
            sb.append(ch);
            
            for(char chIn: map.get(ch)){
                inDegree.put(chIn, inDegree.get(chIn) - 1);
                if(inDegree.get(chIn) == 0){
                    q.offer(chIn);
                }
            }
        }
        
        return sb.length() == map.size()? sb.toString(): "";
    }
}