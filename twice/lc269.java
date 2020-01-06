class Solution {
    
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        buildGraph(words, graph, indeg);
        
        return bfs(graph, indeg);
    }
    
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indeg) {
        for(String word : words) {
            char[] chArr = word.toCharArray();
            for(char c : chArr) {
                graph.putIfAbsent(c, new HashSet<Character>());
                indeg.put(c, 0);
            }
        }
        
        for(int i = 1; i < words.length; i ++) {
            String prev = words[i - 1];
            String curr = words[i];
            
            int minLen = Math.min(prev.length(), curr.length());
            
            for(int j = 0; j < minLen; j ++) {
                char prevC = prev.charAt(j);
                char currC = curr.charAt(j);
                
                if(prevC != currC) {
                    if(!graph.get(prevC).contains(currC)) {
                        graph.get(prevC).add(currC);
                        indeg.put(currC, indeg.get(currC) + 1);
                    }
                    
                    break;
                }
            }
        }
    }
    
    private String bfs(Map<Character, Set<Character>> graph, Map<Character, Integer> indeg) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : graph.keySet()) {
            if(indeg.get(c) == 0) {
                q.offer(c);
            }
        }
        
        while(!q.isEmpty()) {
            char c = q.poll();
            sb.append(c); 
            
            for(char c2 : graph.get(c)) {
                indeg.put(c2, indeg.get(c2) - 1);
                if(indeg.get(c2) == 0) {
                    q.offer(c2);
                }
            }
        }
        
        return sb.length() == graph.size() ? sb.toString() : "";
    }
}