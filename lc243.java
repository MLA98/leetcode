// O(m) O(1) solution
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words.length < 2){
            return -1;
        }

        int i = 0;
        int ans = Integer.MAX_VALUE;
        int l1 = -1;
        int l2 = -1;
        
        for(String word: words){
            if(word.equals(word1)){
                l1 = i;
                if(l2 != -1){
                    ans = Math.min(ans, Math.abs(l1 - l2));
                }
            }
            
            if(word.equals(word2)){
                l2 = i;
                if(l1 != -1){
                    ans = Math.min(ans, Math.abs(l1 - l2));
                }
            }    
            i ++;
        }
        
        
        return ans;
    }
}


// sb force!!! beats 100 in both space and time lol
// m = words.length;
// time: O(m/2 * m/2) => O(m^2)
// space: O(m)

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words.length < 2){
            return -1;
        }
        List<Integer> loc1 = new LinkedList<>();
        List<Integer> loc2 = new LinkedList<>();
        int i = 0;
        
        for(String word: words){
            if(word.equals(word1)){
                loc1.add(i);
            }
            
            if(word.equals(word2)){
                loc2.add(i);
            }    
            i ++;
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int l1: loc1){
            for(int l2: loc2){
                ans = Math.min(ans, Math.abs(l1 - l2));
            }
        }
        
        return ans;
    }
}

