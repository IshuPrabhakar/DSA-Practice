class TrieNode{
    private TrieNode[] links;
    private LinkedList<String> suggestion;
    
    public TrieNode(){
        links = new TrieNode[26];
        suggestion = new LinkedList<>();
    }
    
    public TrieNode getlink(char c){
        return this.links[c - 'a'];
    }
    
    public void setlink(char c){
        this.links[c - 'a'] = new TrieNode();
    }
    
    public int suggestionListSize(){
        return suggestion.size();
    }
    
    public void addProducts(String p){
        this.suggestion.offer(p);
    }
    
    public LinkedList<String> getSuggestion(){
        return this.suggestion;
    }
}

class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        
        // sort the array list so that products will be added in sorted order in suggestions list
        Arrays.sort(products);
        
        for(String product : products){
            TrieNode curr = root;
            
            for(char c : product.toCharArray()){
                
                if(curr.getlink(c) == null)
                    curr.setlink(c);
                
                curr = curr.getlink(c);
                
                // add the products of having same prefix in every single node
                if(curr.suggestionListSize() < 3)
                    curr.addProducts(product);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for(char c : searchWord.toCharArray()){
            if(root != null)
                root = root.getlink(c);
            result.add(root == null ? Arrays.asList() : root.getSuggestion());
        }
        
        return result;
    }
}
