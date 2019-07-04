// First time I copied solution One
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

// The runtime is O(NKlogK) Klogk is the sort algo, N is the outer for loop.
// The space is O(NK), worst case all string are different and large.

// Second time I copy solution two
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap<>();
        int[] occurrence = new int[26];
        for(String st: strs){
            Arrays.fill(occurrence, 0);
            for(char c: st.toCharArray()){
                occurrence[c - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i ++){
                sb.append('#');
                sb.append(occurrence[i]);
            }
            
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), new ArrayList<String>());
            }
            map.get(sb.toString()).add(st);
        }
        return new ArrayList(map.values());
    }
}

// It is shitty that this solution is slower than the first. lol