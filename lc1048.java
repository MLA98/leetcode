class Solution {
    // Basically dynamic programming.
    // Sort it and traverse the array.
    // Instead of add some element
    // We delete the letter of a string and find the ones before
    
    public int longestStrChain(String[] words) {
        if(words == null || words.length == 0) {
            return 0;
        }
        
        int max = 0;
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        
        for(String word : words) {
            if(map.containsKey(word)) {
                continue;
            }
            
            map.put(word, 1);
            
            for(int i = 0; i < word.length(); i ++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String s = sb.toString();
                int count = map.getOrDefault(s, 0);
                map.put(word, Math.max(map.get(word), count + 1));
            }
            
            max = Math.max(max, map.get(word));
        }
        
        return max;
    }
}