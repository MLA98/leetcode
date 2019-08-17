class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words.length == 0){
            return new LinkedList<>();
        }
        // easy soln
        Map<String, Integer> counts = new HashMap<>();
        List<Integer> ans = new LinkedList<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        int m = s.length();
        int n = words.length;
        int len = words[0].length();
        
        for(int i = 0; i < m - n * len + 1; i ++){
            boolean found = true;
            Map<String, Integer> seen = new HashMap<>();
            for(int j = 0; j < n; j ++){
                String sub = s.substring(i + j * len, i + (j + 1) * len);
                if(counts.containsKey(sub)){
                    if(seen.getOrDefault(sub, 0) >= counts.get(sub)){
                        found = false;
                        break;
                    }
                    else{
                        seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    }
                }
                else{
                    found = false;
                    break;
                }
            }
            
            if(found){
                ans.add(i);
            }
        }
        
        return ans;
    }
}