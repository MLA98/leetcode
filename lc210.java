// time: O(n)
// space:  O(n) inner stack calls
class Solution {
    Stack<Integer> stack;
    Map<Integer, List<Integer>> graph;
    boolean[] black;
    boolean[] grey;
    boolean cycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        stack = new Stack();
        graph = new HashMap();
        black = new boolean[numCourses];
        grey = new boolean[numCourses];
        int[] ans = new int[numCourses];
        
        for(int[] pre: prerequisites){
            List<Integer> list = 
                graph.getOrDefault(pre[1], new LinkedList<Integer>());
            list.add(pre[0]);
            graph.put(pre[1], list);
        }
        
        for(int i = 0; i < numCourses; i ++){
            dfs(i);
        }
        
        if(cycle){
            return new int[0];
        }
        
        int index = 0;
        while(!stack.empty()){
            ans[index] = stack.pop();
            index ++;
        }
        
        return ans;
    }
    
    private void dfs(int visit){
        if(grey[visit]){
            cycle = true;
        }
        else if(!black[visit]){
            grey[visit] = true;
            List<Integer> list = graph.get(visit);
            if(list != null)
                for(int node: list){
                    dfs(node);
                }
            stack.push(visit);
            black[visit] = true;
            grey[visit] = false;
        }
    }
}


// indegree method
// time: O(n);
// space: O(n)

class Solution {
    // int[] inDegree;
    // Map<Integer, List<Integer>> graph;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap();
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        
        for(int[] pre: prerequisites){
            inDegree[pre[0]] ++;
            List<Integer> list = 
                graph.getOrDefault(pre[1], new LinkedList<Integer>());
            list.add(pre[0]);
            graph.put(pre[1], list);
        }
        
        
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        
        int index = 0;
        while(!q.isEmpty()){
            int taken = q.poll();
            ans[index] = taken;
            if(graph.containsKey(taken)){
                for(int child: graph.get(taken)){
                    inDegree[child] --;
                    if(inDegree[child]  == 0){
                        q.add(child);
                    }
                }
            }
            ans[index] = taken;
            index ++;
        }
        
        if(index != numCourses){
            return new int[0];
        }
        
        return ans;
    }
}