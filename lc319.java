class Solution {
    public int bulbSwitch(int n) {
        int sqrt = 1;
        int count = 0;
        
        for(int i = 1; i <= n; i ++){
            if(sqrt * sqrt == i){
                count ++;
                sqrt ++;
            }
        }
        
        return count;
    }
}

class Solution {
    public int bulbSwitch(int n) {

        return (int)Math.sqrt(n);
    }
}