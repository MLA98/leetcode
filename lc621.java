class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char task: tasks){
            int count = map.getOrDefault(task, 0);
            map.put(task, count + 1);
        }
        
        // 最大值先滚的最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (w1, w2) -> w2 - w1
        );
        
        for(int taskCount: map.values()){
            heap.offer(taskCount);
        }
        
        
        // Cooldown start time to taskCount map
        Map<Integer, Integer> coolDown = new HashMap<>();
        
        int timeTaken = 0;
        while(!heap.isEmpty() || !coolDown.isEmpty()){
            if(coolDown.containsKey(timeTaken - n - 1) ){
                heap.offer(coolDown.remove(timeTaken - n - 1));
            }
            
            if(!heap.isEmpty()){
                int leftTasks = heap.poll() - 1;
                if(leftTasks != 0){
                    coolDown.put(timeTaken, leftTasks);
                }
            }
            
            timeTaken ++;
        }
        
        return timeTaken;
    }
}