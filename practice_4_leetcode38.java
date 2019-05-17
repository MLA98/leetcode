class Solution {
    public String countAndSay(int n) {
        // FUCK THIS DESCRIPTATION
        StringBuilder prev = new StringBuilder("1");
        char say;
        StringBuilder curr = new StringBuilder("1");;
        int count;
        for (int i = 1; i < n; i ++){
            say = prev.charAt(0);
            count = 1;
            curr = new StringBuilder();
            for (int j = 1; j < prev.length(); j ++){
                if (prev.charAt(j) != say){
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);
                }
                else{
                    count ++;
                }
            }
            curr.append(count).append(say);
            prev = curr;
        }
        return curr.toString();
    }
}
