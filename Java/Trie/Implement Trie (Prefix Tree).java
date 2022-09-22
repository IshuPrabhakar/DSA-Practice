class TrieNode{
    public TrieNode[] links;
    public boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEndOfWord(){
        return isEnd;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            // Creating new node for each character
            if(curr.links[c - 'a'] == null)
                curr.links[c - 'a'] = new TrieNode();
            
            curr = curr.links[c - 'a'];
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            // First check for null then move pointer to next node
            if(curr.links[c - 'a'] == null)
                return false;
            
            curr = curr.links[c - 'a'];
        }
        
        return curr.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            
            // First check for null then move pointer to next node
            if(curr.links[c - 'a'] == null)
                return false;
            
            curr = curr.links[c - 'a'];

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
