/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// O(n^2) O(1) solution
      public class Solution extends Relation {
        public int findCelebrity(int n) {
            List<Integer> celebCols = new ArrayList<>();
            
            for(int i = 0; i < n; i ++){
                int oneCount = 1;
                for(int j = 0; j < n; j ++){
                    oneCount += knows(j, i)? 1: 0;
                    if(oneCount == n + 1){
                        celebCols.add(i);
                    }
                }
            }
            
            for(int celeb: celebCols){
                int know = 0;
                for(int i = 0; i < n; i ++){
                    know += knows(celeb, i)? 1:0;
                }
                if(know == 1){
                    return celeb;
                }
            }
            
            return -1;
        }
    }


// O(n) O(n)
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n == 1){
                return 0;
            }
            
            if(n == 0){
                return -1;
            }
            
            Stack<Integer> stack = new Stack<>();
            
            for(int i = 0; i < n; i ++){
                stack.push(i);
            }
            
            while(stack.size() > 1){
                int a = stack.pop();
                int b = stack.pop();
                
                if(knows(a, b)){
                    stack.push(b);
                }
                else{
                    stack.push(a);
                }
            }
            
            int c = stack.pop();
            
            for(int i = 0; i < n; i ++){
                if(i != c && (!knows(i, c) || knows(c, i))){
                    return -1;
                }
            }
            
            return c;
        }
    }



/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
      public class Solution extends Relation {
        public int findCelebrity(int n) {
            if(n == 1){
                return 0;
            }
            
            if(n == 0){
                return -1;
            }
            
            int c = 0;
            
            for(int i = 0; i < n; i ++){
                if(knows(c, i)){
                    c = i;
                }
            }
            
            for(int i = 0; i < n; i ++){
                if(i != c && (!knows(i, c) || knows(c, i))){
                    return -1;
                }
            }
            
            return c;
        }
    }