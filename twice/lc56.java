class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0){
            return new int[0][0];
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();  
        for(int[] interval: intervals){
            if(list.size() == 0){
                list.add(new int[] {interval[0], interval[1]});
                continue;
            }
            int tail = list.get(list.size() - 1)[1];
            int head = interval[0];
            if(tail >= head){
                list.get(list.size() - 1)[1] = Math.max(tail, interval[1]);
            }
            else{
                list.add(new int[] {interval[0], interval[1]});
            }
        }
        
        int[][] ans = new int[list.size()][2];
        int j = 0;
        for(int[] a: ans){
            a[0] = list.get(j)[0];
            a[1] = list.get(j)[1];
            j ++;
        }
        
        return ans;
    }
}