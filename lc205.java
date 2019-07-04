class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();
        int sVal = 0;
        for(int i = 0; i < s.length(); i ++){
            if(maps.containsKey(s.charAt(i))){
                sVal = sVal * 10 + maps.get(s.charAt(i));
            }
            else{
                maps.put(s.charAt(i), maps.size() + 1);
                sVal = sVal * 10 + maps.get(s.charAt(i));
            }
        }
        int tVal = 0;
        for(int i = 0; i < t.length(); i ++){
            if(mapt.containsKey(t.charAt(i))){
                tVal = tVal * 10 + mapt.get(t.charAt(i));
            }
            else{
                mapt.put(t.charAt(i), mapt.size() + 1);
                tVal = tVal * 10 + mapt.get(t.charAt(i));
            }
        }
        return sVal == tVal;
    }
}

// Right approach
