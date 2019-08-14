class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int p = 0;
        int q = 0;
        
        while(p < v1.length || q < v2.length){
            int subV1 = p < v1.length? Integer.parseInt(v1[p]): 0;
            int subV2 = q < v2.length? Integer.parseInt(v2[q]): 0;
            if(subV1 > subV2){
                return 1;
            }
            else if(subV1 < subV2){
                return -1;
            }
            
            p ++;
            q ++;
        }
        
        return 0;
    }
}