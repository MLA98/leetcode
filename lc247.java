class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int m, int n){
        // Two base cases, this is for even number
        if(m == 0){
            return Arrays.asList("");
        }
        else if(m == 1){
            return Arrays.asList("0", "1", "8");
        }
        
        List<String> prev = helper(m - 2, n);
        List<String> curr = new LinkedList<>();
        
        for(String s: prev){
            // For avoiding 0880 
            if(m != n){
                curr.add("0" + s + "0");
            }
            
            curr.add("1" + s + "1");
            curr.add("6" + s + "9");
            curr.add("8" + s + "8");
            curr.add("9" + s + "6");
        }
        
        return curr;
    }
}