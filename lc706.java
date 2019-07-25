class MyHashMap {

    private ListNode[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = myHashCode(key);
        if(map[i] == null){
            map[i] = new ListNode(-1 , -1);
        }
        
        ListNode prev = find(map[i], key);
        if(prev.next == null){
            prev.next = new ListNode(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = myHashCode(key);
        
        if(map[i] == null){
            return -1;
        }
        
        ListNode prev = find(map[i], key);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = myHashCode(key);
        if(map[i] == null){
            return;
        }
        ListNode prev = find(map[i], key);
        if(prev.next == null){
            return;
        }
        prev.next = prev.next.next;
    }
    
    class ListNode {
        int key, value;
        ListNode next;
        
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private int myHashCode(int key){
        return key % 10000;
    }
    
    private ListNode find(ListNode bucket, int key){
        ListNode node = bucket;
        ListNode prev = null;
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */