class Solution {
    public String removeDuplicates(String s, int k) {
        
        // Approach is to use stack to keep track of previous characters
        // We can also make use of custom class like pair
        
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            
            if(stack.isEmpty() || stack.peek().getKey() != c){
                stack.push(new Pair<>(c, 1));
            }
            else{
                // Since Pair is immutable in java so we have create new pair
                // with new value and delete existing one
                Pair<Character, Integer> curr = stack.pop();
                stack.push(new Pair<>(curr.getKey(), curr.getValue() + 1));
                
                if(stack.peek().getValue() == k)
                    stack.pop();
            }
        }
        
        // constructing the final string
        String finalString = "";
        while(!stack.isEmpty()) {
            Pair<Character, Integer> pair = stack.pop();
            int count = pair.getValue();
            
            while(count-- > 0){
                finalString = pair.getKey() + finalString;
            }
        }
        
        return finalString;
    }
}
