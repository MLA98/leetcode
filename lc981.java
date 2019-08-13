class TimeMap {
    class Node {
        int timestamp;
        String value;
        Node(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    Map<String, List<Node>> M;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        M = new HashMap<>();
    }
    
    // O(1)
    public void set(String key, String value, int timestamp) {
        M.putIfAbsent(key, new ArrayList<>());
        M.get(key).add(new Node(timestamp, value));
    }
    
    // O(logn)
    public String get(String key, int timestamp) {
        List<Node> list = M.getOrDefault(key, null);
        
        if(list == null || list.get(0).timestamp > timestamp){
            return "";
        }
        
        int l = 0;
        int r = list.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(list.get(mid).timestamp > timestamp){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return list.get(r).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */