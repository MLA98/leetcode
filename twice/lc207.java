class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0 || numCourses == 0){
            return true;
        }
        int[] indegree = new int[numCourses];
        int classFinished = 0;
        
        // Index 0 of preq is the class that need other classes
        for(int[] preq : prerequisites){
            indegree[preq[0]] ++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                // If a class does not need any preq, 
                q.offer(i);
            }
        }
        
        classFinished = q.size();
        while(!q.isEmpty()){
            int classTaken = q.poll();
            
            for(int[] preq : prerequisites){
                if(preq[1] == classTaken){
                    indegree[preq[0]] --;
                    if(indegree[preq[0]] == 0){
                        classFinished ++;
                        q.offer(preq[0]);
                    }
                }
            }
        }
        
        return (classFinished == numCourses);
    }
}