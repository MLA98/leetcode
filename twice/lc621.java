class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // Map the each task to its total count;
        Map<Character, Integer> countMap = new HashMap();
        for(char task : tasks) {
            countMap.put(task, countMap.getOrDefault(task, 0) + 1);
        }
        
        // descedning queue to get the largest in poll.
        PriorityQueue<Integer> descendQueue = new PriorityQueue<>((a, b) -> b - a);
        
        for(int val : countMap.values()) {
            descendQueue.offer(val);
        }
        
        // Map the time it is cooled to the count of the val;
        Map<Integer, Integer> coolDown = new HashMap();
        
        // The glabal time for the tasks.
        int time = 0;
        
                
        while(!coolDown.isEmpty() || !descendQueue.isEmpty()) {
            if(coolDown.containsKey(time - n - 1)) {
                descendQueue.offer(coolDown.remove(time - n - 1));
            }
            
            if(!descendQueue.isEmpty()) {
                int count = descendQueue.poll();
                if(count - 1 != 0){
                    coolDown.put(time, count - 1);   
                }
            }
            
            time ++;
        }
        
        return time;
    }
}