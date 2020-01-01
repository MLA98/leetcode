class MyHashMap {
    // Only 10000 operations means that there is at most 10000 put could happen.
    // Therefore, we may need to have an array storign the 10000 element.
    // However, the value possiblity is 0-1000000, 
    // So we may need a hash function to transcode the value into 10000 hash
    // 
    
    
    
     class ListNode {
        private int val;
        private ListNode next;
        private int originalKey;
        
        public ListNode(int val, int originalKey) {
            this.val = val;
            this.next = null;
            this.originalKey = originalKey;
        }
    }
    
    private ListNode[] hashMap;
    
    public int hashCode(int key){
        return key % 10000;
    }
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hashCode(key);
        
        if(hashMap[hash] == null) {
            // Dummy node
            hashMap[hash] = new ListNode(-1, -1);
            hashMap[hash].next = new ListNode(value, key);
            return;
        }
        else {
            ListNode trav = hashMap[hash].next;
            ListNode prev = hashMap[hash];
            while(trav != null){
                if(trav.originalKey == key){
                    trav.val = value;
                    return;
                }
                prev = trav;
                trav = trav.next;
            }
            
            prev.next = new ListNode(value, key);   
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hashCode(key);
        if(hashMap[hash] == null){
            return -1;
        }
        
        ListNode trav = hashMap[hash].next;
        while(trav != null){
            if(trav.originalKey == key){
                return trav.val;
            }
            
            trav = trav.next;
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hashCode(key);
        if(hashMap[hash] == null){
            return;
        }
        
        ListNode trav = hashMap[hash].next;
        ListNode prev = hashMap[hash];
        while(trav != null){
            if(trav.originalKey == key){
                prev.next = trav.next;
                return;
            }
            
            prev = trav;
            trav = trav.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */