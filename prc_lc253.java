// minHeap is quite useful.
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> Q = new PriorityQueue<Integer>(
        intervals.length,
        new Comparator<Integer>(){
           public int compare(Integer a, Integer b){
               return a - b;
           } 
        });
        
        Q.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i ++){
            if(intervals[i][0] >= Q.peek()){
                Q.poll();
            }
            
            Q.add(intervals[i][1]);
        }
        
        return Q.size();
    }
}