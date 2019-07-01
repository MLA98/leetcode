public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initialize the graph.
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i ++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i ++){ 
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] onStack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        boolean[] isCycle = new boolean[1];

        for(int i = 0; i < numCourses; i ++){
            if(!visited[i]){
                dfs(onStack, visited, isCycle, i, graph);
            }
        }
        
        return !isCycle[0];
    }

    private void dfs(boolean[] onStack, boolean[] visited, boolean[] isCycle, int k, ArrayList<Integer>[] graph){
        onStack[k] = true;
        visited[k] = true;
        for(int i = 0; i < graph[k].size(); i ++){
            if(!visited[graph[k].get(i)]){
                dfs(onStack, visited, isCycle, graph[k].get(i), graph);
            }
            else if(onStack[graph[k].get(i)]){
                isCycle[0] = true;
            }
        }
        onStack[k] = false;
    }
}
