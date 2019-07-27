class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        for(String word: words){
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        
        // Memorizing the overwrite 
        PriorityQueue<String> Q = new PriorityQueue<>(
            (w1, w2) -> map.get(w1).equals(map.get(w2))? 
                w2.compareTo(w1): map.get(w1) - map.get(w2)
        );
        
        // 比数字大小的时候 w1 - w2 来造成Max heap的状态
        // 当出现次数一致时，则alph比较小的权重高，相当于 w2 - w1。
        // 用campareTo方法自然就是w2.compareTo(w1)
        
        for(String key: map.keySet()){
            Q.offer(key);
            if(Q.size() > k){
                Q.poll();
            }
        }
        
        while(Q.size() > 0){
            ans.add(Q.poll());
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}