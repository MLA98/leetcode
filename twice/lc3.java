class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int left = 0;
        int right = 0;
        
        Set<Character> currChars = new HashSet<>();
        boolean valid = true;
        char[] arr = s.toCharArray();
        int max = 1;
        currChars.add(arr[0]);
        
        while(right < s.length()) {
            if(valid) {
                right ++;
                if(right == s.length()) {
                    break;
                }
                if(currChars.contains(arr[right])) {
                    valid = false;
                }
                else{
                    max = Math.max(right - left + 1, max);
                }
                   
                currChars.add(arr[right]);
            }
            else{
                left ++;
                if(arr[left - 1] == arr[right]) {
                    valid = true;
                    max = Math.max(right - left + 1, max);
                }
                else{
                    currChars.remove(arr[left - 1]);
                }
            }
        }
        
        return max;
    }
}
