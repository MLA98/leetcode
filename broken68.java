class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int count = 0;
        List<String> toGen = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        for(int i = 0; i < words.length; ){
            if(count + words[i].length() + 1 <= maxWidth + 1){
                toGen.add(words[i]);
                count += words[i].length() + 1;
                i ++;
            }
            else{
                ans.add(generator(toGen, maxWidth));
                toGen = new LinkedList<>();
                count = 0;
            }
        }
        
        if(toGen.size() > 0){
            int size = maxWidth;
            StringBuilder sb = new StringBuilder();
            for(String s: toGen){
                sb.append(s);
                sb.append(' ');
                size -= s.length() + 1;
            }
            
            for(int i = 0; i < size; i ++){
                sb.append(' ');
            }
            ans.add(sb.toString());
        }
        
        return ans;
    }
    
    private String generator(List<String> words, int maxWidth){
        // System.out.println("hey");
        int wordLength = 0;
        
        for(String s: words){
            wordLength += s.length();
        }
        
        int spaceCount = maxWidth - wordLength;
        int space = spaceCount / (words.size() - 1);
        int extra = spaceCount % (words.size() - 1);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < words.size(); i ++){
            sb.append(words.get(i));
            if(i != words.size() - 1)
                for(int j = 0; j < space; j ++){
                    sb.append(' ');
                }
            
            if(extra > 0){
                sb.append(' ');
                extra --;
            }
        }
        
        return sb.toString();
    }
}