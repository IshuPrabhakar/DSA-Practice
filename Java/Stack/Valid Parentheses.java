class Solution {
    public boolean isValid(String s) {
        
        // if we found an opening bracket then we insert a closing bracket of its corresponding
        // after inserting couple of opening brackets, we check at each step is the last closing
        // bracket is equal to the last element of stack or not if not then return false
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(Character c : s.toCharArray()) {
            
            if(c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        
        // At this stage stack should be empty now if not then parenthesis are not valid
        return stack.isEmpty();
    }
}
