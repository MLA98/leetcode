class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        
        // Build graph
        for(List<String> account: accounts){
            String name = "";
            for(String email: account){
                if(name == ""){
                    name = email;
                    continue;
                }
                
                graph.computeIfAbsent(email, k -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), k -> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }
        
        Set<String> seen = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();
        
        for(String email: graph.keySet()){
            if(!seen.contains(email)){
                Stack<String> stack = new Stack();
                seen.add(email);
                stack.push(email);
                List<String> component = new ArrayList();
                // Here we compute all emails to one owner.
                while(!stack.empty()){
                    String node = stack.pop();
                    component.add(node);
                    for(String nei: graph.get(node)){
                        if(!seen.contains(nei)){
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        
        return ans;
    }
}