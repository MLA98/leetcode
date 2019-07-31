class Solution {
    public List<Integer> partitionLabels(String S) {
        // 快死了
        List<Integer> ans = new LinkedList<>();
        if(S.length() == 0){
            return ans;
        }
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i ++){
            last[S.charAt(i) - 'a'] = i;
        }
        
        int j = 0;
        int anchor = 0;
        
        for(int i = 0; i < S.length(); i ++){
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if(i == j){
                ans.add(j - anchor + 1);
                j = 0;
                anchor = i + 1;
            }
        }
        
        return ans;
    }
}