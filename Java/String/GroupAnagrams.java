class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // Approach is to make a Hashmap
        // calculate the frequency of words and add that as key in
        // hasmap and group all the similar words corresponding to that key
        // retrun the value set of hashmap as list.
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String word : strs) {
            
            // make char frequency array
            char[] freq = new char[26];
            for(char c : word.toCharArray()) 
                freq[c - 'a']++;
            
            // making key of char array
            String key = String.valueOf(freq);
            
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            
            // Addding word to the freq string key
            map.get(key).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
