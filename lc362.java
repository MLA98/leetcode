// not scalable solution with O(1) O(1) as we need so much memory to store the hits.
class HitCounter {

    Queue<Integer> q;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.q = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(q.size() > 0 && timestamp - q.peek() >= 300){
            q.poll();
        }
        
        return q.size();
    }
}

// scalable solution
class HitCounter {

    /** Initialize your data structure here. */
    private int[] hits;
    private int[] timestamps;
    public HitCounter() {
        this.hits = new int[300];
        this.timestamps = new int[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(timestamps[index] == timestamp){
            hits[index] ++;
        }
        else{
            timestamps[index] = timestamp;
            hits[index] = 1;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int count = 0;
        for(int i = 0; i < 300; i ++){
            if(timestamp - timestamps[i] < 300){
                count += hits[i];
            }
        }
        
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

