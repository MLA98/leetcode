// Recursive approach
// Getting all possibilities.
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // Recursive aproach
        List<Integer> ans = new ArrayList<>();
        for(int k = 0; k < input.length(); k ++){
            char c = input.charAt(k);
            if(Character.isDigit(c)){
                continue;
            }
            List<Integer> left = diffWaysToCompute(input.substring(0, k));
            List<Integer> right = diffWaysToCompute(input.substring(k + 1));
            for(int i = 0; i < left.size(); i ++){
                for(int j = 0; j < right.size(); j ++){
                    int l = left.get(i);
                    int r = right.get(j);
                    int res = 0;
                    switch(c){
                        case '+': 
                            res = l + r;
                            break;
                        case '-':
                            res = l - r;
                            break;
                        case '*':
                            res = l * r;
                            break;
                    }
                    ans.add(res);
                }
            }
        }
        if(ans.size() == 0){
            if(input.length() == 0){
                ans.add(0);
            }
            else{
                ans.add(Integer.valueOf(input));
            }
        }
        return ans;
    }
}

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        // Recursive aproach
        List<Integer> ans = new ArrayList<>();
        for(int k = 0; k < input.length(); k ++){
            char c = input.charAt(k);
            if(Character.isDigit(c)){
                continue;
            }
            List<Integer> left = diffWaysToCompute(input.substring(0, k));
            List<Integer> right = diffWaysToCompute(input.substring(k + 1));
            for(int i = 0; i < left.size(); i ++){
                for(int j = 0; j < right.size(); j ++){
                    int l = left.get(i);
                    int r = right.get(j);
                    int res = 0;
                    switch(c){
                        case '+': 
                            res = l + r;
                            break;
                        case '-':
                            res = l - r;
                            break;
                        case '*':
                            res = l * r;
                            break;
                    }
                    ans.add(res);
                }
            }
        }
        if(ans.size() == 0){
            if(input.length() == 0){
                ans.add(0);
            }
            else{
                ans.add(Integer.valueOf(input));
            }
        }
        map.put(input, ans);
        return ans;
    }
}