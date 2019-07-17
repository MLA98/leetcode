// Brute force would compare one event with every event
// to see if they are overlap 
// O(n^2) not efficient

// sort the array by first element and then check if the later event is conflicted with 
// the one earlier.
// Comparator override is important dude!
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < intervals.length - 1; i ++){
            if(intervals[i][1] > intervals[i + 1][0]){
                return false;
            }
        }
        
        return true;
    }
}