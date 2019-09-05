// Fast and nearly bug free.
// But I did dfs twice which make the efficiency bad.
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        dfs(node);
        connect();
        return map.get(node);
    }
    
    private void dfs(Node node){
        if(node == null || map.containsKey(node)){
            return;
        }
        
        Node newNode = new Node(node.val, new LinkedList<>());
        map.put(node, newNode);
        for(Node n: node.neighbors){
            dfs(n);
        }
    }
    
    private void connect(){
        for(Node n: map.keySet()){
            Node newNode = map.get(n);
            for(Node nei: n.neighbors){
                newNode.neighbors.add(map.get(nei));
            }
        }
    }
}

// One time dfs which make the speed much better.
class Solution {
    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return helper(node);
    }
    
    private Node helper(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        Node newNode = new Node(node.val, new LinkedList<>());
        map.put(node, newNode);
        for(Node n: node.neighbors){
            newNode.neighbors.add(helper(n));
        }
        return newNode;
    }
}