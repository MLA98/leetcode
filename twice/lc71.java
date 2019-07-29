class Solution {
    public String simplifyPath(String path) {
        //hek 
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList(".", "..", ""));
        for (String dir : path.split("/")){
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String ans = "";
        while (!stack.isEmpty()){
            ans = "/" + stack.pop() + ans;
        }
        if (ans.equals("")){
            return "/";
        }
        return ans;
    }
} 

// Basically, it is copied. Path-related could be solved by stack.
// I once wanted to use tree which is far more complicated.
// "==" and .equals are significantly different! 
// "==" tries to compare if the values around it refer to the same object
// .equals() tries to compare the value of both of them. 
 

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        String folder = "";
        
        for(int i = 0; i < path.length();){
            char c = path.charAt(i);
            if(c == '/'){
                if(folder.length() > 0){
                    stack.push(folder);
                    folder = "";
                }
                i ++;
            }
            else if(c == '.'){
                if(i + 2 < path.length() && 
                  path.charAt(i + 1) == '.' &&
                  path.charAt(i + 2) != '.'){
                    stack.push("...");
                    i += 3;
                }
                else if(i + 1 < path.length() &&
                  path.charAt(i + 1) == '.'){
                    if(!stack.empty()){
                        stack.pop();
                    }
                    i += 2;
                }
                else{
                    i ++;
                }
            }
            else{
                folder = folder + c;
                i ++;
            }
        }
        
        if(folder.length() > 0){
            stack.push(folder);
        }
        

        String ans = "";
        while(!stack.empty()){
            ans = "/" + stack.pop() + ans;
        }
        
        if(ans == ""){
            return "/";
        }
        
        return ans;
    }
}
