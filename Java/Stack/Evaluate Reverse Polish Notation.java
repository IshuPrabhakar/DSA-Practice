class Solution {
    public int evalRPN(String[] tokens) {
        
        // This is also called as PostFix
        
        // Stack of Integer should be used as it makes more sense here
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(String token : tokens) {
            
            if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(token.equals("/")) {
                // first stack.pop() will pop diviser
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            }
            else if(token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}
