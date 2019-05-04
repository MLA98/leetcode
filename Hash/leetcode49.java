class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String st : strs){
            char[] ca_st = st.toCharArray();
            Arrays.sort(ca_st);
            String st2 = new String(ca_st);
            if (!map.containsKey(st2)){
                map.put(st2, new ArrayList<String>());
            }
            map.get(st2).add(st);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
}


// This is to get the presence of each alphabet. Dont need any sort so O(NK) runtime.
// Full of tricks of manipulating strings. Have to practice and remeber them!