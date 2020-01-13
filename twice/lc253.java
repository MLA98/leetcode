class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        
        if(intervals.length == 1) {
            return 1;
        }
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        minHeap.offer(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i ++) {
            if(minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}