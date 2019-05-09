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
 
