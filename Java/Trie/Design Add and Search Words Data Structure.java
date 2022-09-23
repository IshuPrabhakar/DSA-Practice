// TC => O(n + 26^n)
// SC => O(n)

class TrieNode{
    private TrieNode[] links;
    private boolean isEnd;
    
    public TrieNode(){
        links = new TrieNode[26];
        isEnd = false;
    }
    
    public TrieNode getlink(char c){
       return this.links[c - 'a'];
    }
    
    public TrieNode getlink(int i){
       return this.links[i];
    }
    
    public void setlink(TrieNode node, char c){
        this.links[c - 'a'] = node;
    }
    
    public void setEnd(){
        this.isEnd = true;
    }
    
    public boolean isEndOfWord(){
        return isEnd;
    }
}

class WordDictionary {
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            
            if(curr.getlink(c) == null)
                curr.setlink(new TrieNode(), c);
            
            curr = curr.getlink(c);
        }
        
        curr.setEnd();
    }
    
    public boolean search(String word) {
        return dfs(root, 0, word);
    }
    
    public boolean dfs(TrieNode root, int index, String word){
        if(root == null)
            return false;
        
        if(index == word.length())
            return root.isEndOfWord();
        
        char c = word.charAt(index);
        
        // Simple dfs backtracking function iterating every single character utill
        // it matches all the remaining characters 
        if(c == '.'){
            for(int i = 0; i < 26; i++)
                if(dfs(root.getlink(i), index + 1, word))
                    return true;
        }
        else{
            if(dfs(root.getlink(c), index + 1, word))
                    return true;
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
