class Solution {
    // 似曾
    // Build two string and compare: #22#22....
    // Time: O(n) space: O(n)
    // 似乎并不是很给力
    // sort: O(nlogn) space: O(1) (O(n) in jave as char array is for sort)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] s2 = s.toCharArray();
        char[] t2 = t.toCharArray();
        Arrays.sort(s2);
        Arrays.sort(t2);
        return Arrays.equals(s2, t2);
    }
}


class Solution {
    // O(n) O(n) solution.
    // Using array as hash.
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i ++){
            arr[t.charAt(i) - 'a'] ++;
            arr[s.charAt(i) - 'a'] --;
        }
        
        for(int i : arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}