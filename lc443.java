class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0;
        int j = 0;
        int count = 0;
        
        while(i < chars.length){
            char head = chars[i];
            count = 0;
            j = i;
            
            while(j < chars.length && chars[i] == chars[j]){
                count ++;
                j ++;
            }
            
            chars[index] = head;
            index ++;
            if(count == 1){

            }
            else if(count <= 9){
                chars[index] = (char) (count + '0');
                index ++;
            }
            else{
                String counts = String.valueOf(count);
                for(char c: counts.toCharArray()){
                    chars[index] = c;
                    index ++;
                }
            }
            
            i = j;
        }
        
        return index;
    }
}