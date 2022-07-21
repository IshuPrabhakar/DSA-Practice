class Solution {
    public String removeDuplicateLetters(String s) {
        
        // Approach is that we have to make sure that each character appears 
        // only once we have to maintain their relative order of occurence
        // and return lexicographically smallest string
        
        // we are maintaing mnotonically increasing stack for this approach
        int n = s.length();
        
        // Stack
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        // To mark visited characters
        boolean[] visited = new boolean[26];
        
        // For keeping track of last index of characters
        int[] lastIndex = new int[26];
        for(int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        
        for(int currIndex = 0; currIndex < n; currIndex++) {
            char ch = s.charAt(currIndex);
            
            // skipping duplicates
            if(visited[ch - 'a'])
                continue;
            
            visited[ch - 'a'] = true;

            while( !stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > currIndex) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
        }
        
        
        String finalString = "";
        // this will traverse stack in bottom to top direction
        for(char c : stack)
            finalString = stack.pop() + finalString;
        
        
        return finalString;
    }
}
