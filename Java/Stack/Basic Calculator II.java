class Solution {
    public int calculate(String s) {
        
        // stack to store integmidiate result
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int length = s.length();
        
        int curr_num = 0;
        char sign = '+';
        
        // Here we are doing calculation as soon as we see next variable
        // we need to keep track of previous sign to perform divison and multiplication as it 
        // require prev value for calculation
        
        // NOTE: This can be optimised by without using stack
        for(int i = 0; i < length; i++) {
            
            if(Character.isDigit(s.charAt(i))) {
                
                curr_num = s.charAt(i) - '0';
                // integer can be more of more than two digit
                while( i + 1 < length && Character.isDigit(s.charAt(i + 1)) ) {
                    curr_num = curr_num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
            }
            
            if( (!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) || i == length - 1) {
                
                if(sign == '+'){
                    // if we found + then simply push into the stack
                    stack.push(curr_num);
                }
                
                if(sign == '-'){
                    // if we found - then simply push into the stack after negating
                    // 5-3 => -5, +3 => -2
                    stack.push(-curr_num);
                }
                
                if(sign == '*'){
                    // ex 5 * 3 => curr_num = 3, 3 * stack.pop() => 3 * 5 will give same result
                    // as 5 * 3
                    stack.push(stack.pop() * curr_num);
                }
                
                if(sign == '/'){
                    stack.push(stack.pop() / curr_num);
                }
                
                // reset curr_num
                curr_num = 0;
                sign = s.charAt(i);
            }
        }
        
        // In this stack we are putting intermidiate results
        // after reaching end of the result we have to sum all the values
        // that are present in the stack
        int result = 0;
        while(!stack.isEmpty())
            result += stack.pop();
        
        return result;
    }
}
