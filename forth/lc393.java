class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length;) {
            int ones = 0;
            int value = data[i];
            int mask = (int)Math.pow(2, 7);
            while(value / mask == 1 && ones <= 5) {
                ones ++;
                value -= mask;
                mask /= 2;
            }
            
            if(ones > 4 || ones == 1) {
                return false;
            }
            else if(ones == 0){
                i ++;
            }
            else{
                if(!check(ones, data, i + 1)) {
                    return false;
                }
                i += ones;
            }
            
            
        }
        
        return true;
    }
    
    private boolean check(int size, int[] data, int start) {
        for(int i = start; i < start + size - 1; i ++) {
            if(i > data.length - 1) {
                return false;
            }
            
            if(data[i] / 64 != 2) {
                return false;
            }
        }
        
        return true;
    }
}