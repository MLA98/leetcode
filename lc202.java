class Solution {
    public boolean isHappy(int n) {
        // The happy calculation will eventually go to a loop
        Set<Integer> duplication = new HashSet<>();
        duplication.add(n);
        
        while(n > 1){
            int m = 0;
            while(n > 0){
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            
            if(duplication.contains(m)){
                return false;
            }
            else{
                duplication.add(m);
            }
            n = m;
        }
        
        return true;
    }
}