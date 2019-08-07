// Time: O(2^n) if we always have two options each recursion.
// Space: The stack space would be O(n) as we will recurse until the string is used up.
class Solution {
    private int minLength;
    private Set<String> set; 
    private int length;
    private String s;
    
    private void initialize(String s){
        this.set = new HashSet<>();
        this.minLength = Integer.MAX_VALUE;
        this.length = s.length();
        this.s = s;
    }
    
    private void backtrack(int removeCount, int index, int leftCount, 
                          int rightCount, StringBuilder sb){
        if(removeCount > this.minLength){
            return;
        }
        if(index == this.length){
            if(leftCount != rightCount){
                return;
            }
            
            if(removeCount < this.minLength){
                this.set.clear();
                this.minLength = removeCount;
                this.set.add(sb.toString());
            }
            else if(removeCount == this.minLength){
                this.set.add(sb.toString());
            }
        }
        else{
            char c = this.s.charAt(index);
            if(c == '('){
                backtrack(removeCount + 1, index + 1, leftCount, rightCount, sb);
                sb.append(c);
                backtrack(removeCount, index + 1, leftCount + 1, rightCount, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            else if(c == ')'){
                backtrack(removeCount + 1, index + 1, leftCount, rightCount, sb);
                if(leftCount > rightCount){
                    sb.append(c);
                    backtrack(removeCount, index + 1, leftCount, rightCount + 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else{
                sb.append(c);
                backtrack(removeCount, index + 1, leftCount, rightCount, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        this.initialize(s);
        this.backtrack(0, 0, 0, 0, new StringBuilder());
        return new ArrayList(this.set);
    }
}

