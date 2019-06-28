// I have to say it is a  naive approach.  Keep in mind that "." represents every char in regex.
// You need to use "\\." instead.
class Solution {
    // Dumb method:)
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int[] v1i = new int[v1.length];
        int[] v2i = new int[v2.length];
        for (int i = 0; i < v1.length; i ++){
            v1i[i] = Integer.parseInt(v1[i]);
        }
        for (int i = 0; i < v2.length; i ++){
            v2i[i] = Integer.parseInt(v2[i]);
        }
        int smallerLen = Math.min(v1i.length, v2i.length);
        for (int i = 0; i < smallerLen; i ++){
            if (v1i[i] > v2i[i]){
                return 1;
            }
            else if(v1i[i] < v2i[i]){
                return -1;
            }
        }
        if (v1i.length == v2i.length){
            return 0;
        }
        if (v1i.length > v2i.length){
            for (int i = smallerLen; i < v1i.length; i ++){
                if (v1i[i] != 0){
                    return 1;
                }
            }
        }
        else{
            for (int i = smallerLen; i < v2i.length; i ++){
                if (v2i[i] != 0){
                    return -1;
                }
            }
        }
        return 0;
    }
}
 
// Improved? Same logic but much cleaner! from discussion on Leetcode
// This method automaticly extends the shorter string with 0. 
// Then the iteration goes on until the larger string stops.
public int compareVersion(String version1, String version2) {
    String[] v1Nums = version1.split("\\.");
    String[] v2Nums = version2.split("\\.");
    for(int i = 0; i < v1Nums.length || i < v2Nums.length; i++) {
        int v1Num = (i < v1Nums.length) ? Integer.parseInt(v1Nums[i]) : 0;
        int v2Num = (i < v2Nums.length) ? Integer.parseInt(v2Nums[i]) : 0;
        if(v1Num < v2Num) return -1;
        if(v2Num < v1Num) return 1;
    }
    return 0;
}
