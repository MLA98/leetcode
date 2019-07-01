class TrieNode{
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node){
        links[ch - 'a'] = node;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}


class Trie {

    private TrieNode root; 
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode nodes = root;
        for(int i = 0; i < word.length(); i ++){
            char add = word.charAt(i);
            if (nodes.containsKey(add)){
                nodes = nodes.get(add);
            }
            else{
                nodes.put(add, new TrieNode());
                nodes = nodes.get(add);
            }
        }
        nodes.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode nodes = root;
        for(int i = 0; i < word.length(); i ++){
            char add = word.charAt(i);
            if (!nodes.containsKey(add)){
                return false;
            }
            nodes = nodes.get(add);
        }
        if(!nodes.isEnd()){
            return false;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode nodes = root;
        for(int i = 0; i < prefix.length(); i ++){
            char add = prefix.charAt(i);
            if (!nodes.containsKey(add)){
                return false;
            }
            nodes = nodes.get(add);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
