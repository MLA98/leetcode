class WordDictionary {

    /** Initialize your data structure here. */
    public TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode traverse = this.root;
        for(int i = 0; i < word.length(); i ++){
            char letter = word.charAt(i);
            if (traverse.links[letter - 'a'] == null){
                traverse.links[letter - 'a'] = new TrieNode();
            }
            traverse = traverse.links[letter - 'a'];
        }
        traverse.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode traverse = this.root;
        return helper(traverse, word, 0);
    }
    
    private boolean helper(TrieNode traverse, String word, int start){
        if(start == word.length()){
            return traverse.isEnd;
        }
        
            char letter = word.charAt(start);
            if(letter == '.'){
                for(TrieNode node: traverse.links){
                    if(node != null){
                        if (helper(node, word, start + 1)){
                            return true;
                        }
                    }
                }
                return false;
            }
            else{
                if (traverse.links[letter - 'a'] == null){
                    return false;
                }
                else{
                    return helper(traverse.links[letter - 'a'], word, start + 1);
                }
            }
    }
    
}

// class Trie{
//     public TrieNode root;
//     public Trie(){
//         root = new TrieNode();
//     }
// }

class TrieNode{
    public boolean isEnd;
    public TrieNode[] links;
    public TrieNode(){
        isEnd = false;
        links = new TrieNode[26];
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

 