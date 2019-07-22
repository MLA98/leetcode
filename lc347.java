class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> Q = new PriorityQueue(k);
        
        if(nums.length == 0 || k == 0){
            return ans;
        }
            
        for(int num: nums){
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        for(int value: map.values()){
            Q.add(value);
            if(Q.size() > k){
                Q.poll();
            }
        }
        
        int min = Q.peek();
        for(int key: map.keySet()){
            int count = map.get(key);
            if(count >= min){
                ans.add(key);
            }
        }
        
        return ans;
    }
}