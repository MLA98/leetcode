class Solution {
    // 这题有点憨吧
    // String manipulation
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList();
        Map<String, Integer> map = new HashMap<>();
        for(String st : cpdomains){
            String[] splitedBySpace = st.split(" ");
            int times = Integer.valueOf(splitedBySpace[0]);
            int[] dotOcurrance = new int[2];
            dotOcurrance[1] = -1;
            findDots(splitedBySpace[1], dotOcurrance);
            
            String domain = splitedBySpace[1];
            int preValue = map.getOrDefault(domain, 0);
            map.put(domain, preValue + times);
            
            domain = splitedBySpace[1].substring(dotOcurrance[0] + 1);
            preValue = map.getOrDefault(domain, 0);
            map.put(domain, preValue + times);
            
            if(dotOcurrance[1] != -1){
                domain = splitedBySpace[1].substring(dotOcurrance[1] + 1);
                preValue = map.getOrDefault(domain, 0);
                map.put(domain, preValue + times);
            }
        }
        for(String dom: map.keySet()){
                ans.add(map.get(dom) + " " + dom);
            }
        return ans;
    }
    
    private void findDots(String st,int[] dotOcurrance){
        boolean foundOne = false;
        for(int i = 0; i < st.length(); i ++){
            if(st.charAt(i) == '.'){
                if(foundOne){
                    dotOcurrance[1] = i;
                }
                else{
                    dotOcurrance[0] = i;
                    foundOne = true;
                }
            }
        }
    }
}