class Solution {
    public int strStr(String haystack, String needle) {

        int index_i = 0;
        if (needle.length() == 0){
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            index_i = i;
            for (int j = 0; j < needle.length(); j++){
                if (haystack.charAt(index_i) == needle.charAt(j)){
                    index_i ++;
                }
                else{
                    break;
                }
                if (index_i - i == needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
