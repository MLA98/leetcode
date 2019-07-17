class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        
        if(tickets == null || tickets.size() == 0){
            return ans;
        }
        
        for(List<String> ticket: tickets){
            PriorityQueue<String> destinations = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            destinations.add(ticket.get(1));
            map.put(ticket.get(0), destinations);
        }
        
        String curr = "JFK";
        Stack<String> stack = new Stack();
        
        for(int i = 0; i < tickets.size(); i ++){
            while(map.get(curr) == null || map.get(curr).size() == 0){
                stack.push(curr);
                curr = ans.remove(ans.size() - 1);
            }
            
            ans.add(curr);
            curr = map.get(curr).poll();
        }
        ans.add(curr);
        while(!stack.empty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}