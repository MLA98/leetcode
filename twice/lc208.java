class Trie {
    
    public Trie[] TrieArr;
    public boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        TrieArr = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char[] chArr = word.toCharArray();
        for(char c : chArr) { 
            if(root.TrieArr[c - 'a'] == null){
                root.TrieArr[c - 'a'] = new Trie();
            }
            root = root.TrieArr[c - 'a'];
        }
        
        root.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        char[] chArr = word.toCharArray();
        for(char c : chArr) { 
            if(root.TrieArr[c - 'a'] == null){
                return false;
            }
            root = root.TrieArr[c - 'a'];
        }
        
        if(!root.isEnd) {
            return false;
        }
        
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        char[] chArr = prefix.toCharArray();
        for(char c : chArr) { 
            if(root.TrieArr[c - 'a'] == null){
                return false;
            }
            root = root.TrieArr[c - 'a'];
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