class Solution {
    // Intuitive solution: traverse the string and extract each substring into
    // a arraylist, then use stringbuider to glue them together, of course.
    // The running time is fine which is O(n) but the spacee is shitty. O(n)
    // but O(n) is acceptable i guess?
    // seems what I thought is one of the solutions.
    public String reverseWords(String s) {
        String[] subWords = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subWords.length; i ++){
            if(!subWords[i].equals("")){
                sb.insert(0, subWords[i]);
                if (i != subWords.length - 1){
                    sb.insert(0, " ");
                }
            }
        }
        return sb.toString();
    }
}
