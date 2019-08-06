// O(N) space, how many words in the array, how the dictionary occupies the space.
// O(K * K') cuz I try to come up all combinations.

class WordDistance {
    
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i ++){
            List<Integer> list = map.getOrDefault(words[i], 
                                        new ArrayList<Integer>());
            list.add(i);
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int shortest = Integer.MAX_VALUE;
        
        for(int i = 0; i < list1.size(); i ++){
            for(int j = 0; j < list2.size(); j ++){
                shortest = Math.min(shortest, Math.abs(list1.get(i) - list2.get(j)));
            }
        }
        
        return shortest;
    }
}

// O(N) space, how many words in the array, how the dictionary occupies the space.
// O(N) merge sort.


class WordDistance {
    
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i ++){
            List<Integer> list = map.getOrDefault(words[i], 
                                        new ArrayList<Integer>());
            list.add(i);
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int shortest = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < list1.size() && p2 < list2.size()){
            shortest = Math.min(shortest, Math.abs(list1.get(p1) - list2.get(p2)));
            if(list1.get(p1) < list2.get(p2)){
                p1 ++;
            }
            else{
                p2 ++;
            }
        }
        
        return shortest;
    }
}

