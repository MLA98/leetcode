// sb force 
// TIME: O(N * M)
// SPACE: O(1)
class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() == 0){
            return 0;
        }
        
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i ++){
            if(haystack.charAt(i) == needle.charAt(0)){
                boolean found = true;
                for(int j = 1; j < needle.length(); j ++){
                    if(needle.charAt(j) != haystack.charAt(j + i)){
                        found = false;
                        break;
                    }
                }
                if(found){
                    return i;
                }
            }
        }
        
        return -1;
    }
}

