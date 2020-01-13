class Solution {
    public String reorganizeString(String S) {
        int[] arrCount = new int[26];
        
        for(char c : S.toCharArray()) {
            arrCount[c - 'a'] ++;
        }
        
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                                (a, b) -> arrCount[b] - arrCount[a]);
        
        for(int i = 0; i < 26; i ++) {
            if(arrCount[i] > (S.length() + 1) / 2) {
                return "";
            }
            if(arrCount[i] > 0) {
                pq.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() >= 2) {
            int char1 = pq.poll();
            int char2 = pq.poll();
                        
            sb.append((char)(char1 + 'a'));
            sb.append((char)(char2 + 'a'));
            
            arrCount[char1] --;
            arrCount[char2] --;
            
            
            if(arrCount[char1] > 0) {
                pq.offer(char1);
            }
            
            if(arrCount[char2] > 0) {
                pq.offer(char2);
            }
        }
        
        if(pq.size() == 1) {
            sb.append((char)(pq.poll() + 'a'));
        }
        return sb.toString();   
    }
}