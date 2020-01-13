class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, 
                    (a, b) -> a[0] == b[0] ? 
                                a[1] - b[1]:
                                b[0] - a[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        for(int[] person : people) {
            ans.add(person[1], person);
        }
        
        return ans.toArray(new int[people.length][2]);
    }
}