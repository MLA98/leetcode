class Solution {
    // A little bit tired. Yeah! Excuse!@!
    // Should ve check if val is unique;
    // dfs / bfs running time is O(V + E)
    Map<Integer, Node> traversed = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }
        if (traversed.containsKey(node.val)){
            return traversed.get(node.val);
        }
        
        Node ans = new Node(node.val, new ArrayList<>());
        traversed.put(node.val, ans);
        for (Node neighbor: node.neighbors){
            ans.neighbors.add(cloneGraph(neighbor));
        }
        return ans;
    }
    
    // Yeah, the algo is simple, but you gotta do it more carefully.
}
