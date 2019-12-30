class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new LinkedList<>();
        
        for(int i = 1; i <= n; i++) {
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;
            
            if(!fizz && !buzz){
                Integer num = i;
                ans.add(num.toString());
                continue;
            }
            
            String x = "";
            
            if(fizz){
                x += "Fizz";
            }
            
            if(buzz){
                x += "Buzz";
            }
            
            ans.add(x);
        }
        
        return ans;
    }
}