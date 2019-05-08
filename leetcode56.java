class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1){
            return  intervals;
        }
        // Sort the intervals.
        List<int[]> ansList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i ++){
            if (intervals[i][1] < intervals[i + 1][0]){
                ansList.add(intervals[i]);
            }
            else{
                intervals[i + 1][0] =  intervals[i][0];
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
            }
        }
        ansList.add(intervals[intervals.length - 1]);
        int[][] ans = new int[ansList.size()][];
        for (int j = 0; j < ansList.size(); j ++){
            ans[j] = ansList.get(j);
        }
        return ans;
    }
}

// Sort the array first. Then compare....
