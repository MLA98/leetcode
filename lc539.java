// O(1440) solution
// O(1) which is quite great, not really efficient in some scenarios tho

class Solution {
    // This solution is for brute force trial
    public int findMinDifference(List<String> timePoints) { 
        int min = Integer.MAX_VALUE;
        int twelfHr = 12 * 60;
        int twentyFourHr = 24 * 60;
        boolean[] allMin = new boolean[twentyFourHr];
        for(int i = 0; i < timePoints.size(); i ++){
            String[] splited = timePoints.get(i).split(":");
            int hr = Integer.parseInt(splited[0]);
            int minutes = Integer.parseInt(splited[1]);
            
            int minTotal = hr * 60 + minutes;
            if(allMin[minTotal]){
                return 0;
            }
            allMin[minTotal] = true;
        }
        
        int prev = Integer.MAX_VALUE;
        int first = 0;
        for(int i = 0; i < twentyFourHr; i ++){
            if(prev != Integer.MAX_VALUE && allMin[i]){
                min = Math.min(min, i - prev);
                prev = i;
            }
            
            if(prev == Integer.MAX_VALUE && allMin[i]){
                prev = i;
                first = i;
            }
        }
        
        min = Math.min(min, twentyFourHr - (prev - first));
        
        return min;
    }
}


// Brute force one, O(n^2), O(1) space
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;
        int twelfHr = 12 * 60;
        int twentyFourHr = 24 * 60;
        for(int i = 0; i < timePoints.size(); i ++){
            for(int j = i + 1; j < timePoints.size(); j ++){
                String[] splited1 = timePoints.get(i).split(":");
                String[] splited2 = timePoints.get(j).split(":");
                int hr1 = Integer.parseInt(splited1[0]);
                int min1 = Integer.parseInt(splited1[1]);
                int hr2 = Integer.parseInt(splited2[0]);
                int min2 = Integer.parseInt(splited2[1]);
                
                int minTotal1 = hr1 * 60 + min1;
                int minTotal2 = hr2 * 60 + min2;
                    
                
                int diff = Math.abs(minTotal1 - minTotal2);
                if(diff > twelfHr){
                    diff = twentyFourHr - diff;
                }
                min = Math.min(diff, min);
            }
        }
        
        return min;
    }
}