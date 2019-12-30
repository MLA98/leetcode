class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        if(cpdomains == null){
            return ans;
        }
        
        for(String domain : cpdomains){
            int indexOfSpace = domain.indexOf(" ");
            int count = Integer.parseInt(domain.substring(0, indexOfSpace));
            domain = domain.substring(indexOfSpace + 1, domain.length());
            
            int domainCount = map.getOrDefault(domain, 0);
            map.put(domain, domainCount + count);
            while(domain.contains(".")){
                int indexOfDot = domain.indexOf(".");
                domain = domain.substring(indexOfDot + 1, domain.length());
                domainCount = map.getOrDefault(domain, 0);
                map.put(domain, domainCount + count);
            }
        }
        
        for(String domain : map.keySet()){
            ans.add(map.get(domain).toString() + " " + domain);
        }
        
        return ans;
    }
}