class Solution {
    public boolean validUtf8(int[] data) {
        // Heck it is hard!
        for(int i = 0; i < data.length;){
            if(data[i] >> 7 == 0){
                i ++;
            }
            else if(data[i] >> 5 == 6){
                if(!validHelper(i, 1, data)){
                    return false;
                }
                i += 2;
            }
            else if(data[i] >> 4 == 14){
                if(!validHelper(i, 2, data)){
                    return false;
                }
                i += 3;
            }
            else if(data[i] >> 3 == 30){
                if(!validHelper(i, 3, data)){
                    return false;
                }
                i += 4;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
    
    private boolean validHelper(int start, int length, int[] data){
        if(start + length >= data.length){
            return false;
        }
        for(int i = start + 1; i <= start + length; i ++){
            if(data[i] >> 6 != 2){
                return false;
            }
        }
        return true;
    }
}