class Solution {
    public String removeKdigits(String num, int k) {
        
        // Edge case
        if( k == num.length())
            return "0";
        
        // Stack to store digits in increasing order
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int currDigit = 0; currDigit < num.length(); currDigit++) {
            int currNum = num.charAt(currDigit) - '0';
            
            // when we find any digit lesser than top of the stack
            // we pop out that digit and insert lesser digit
            while(k > 0 && !stack.isEmpty() && stack.peek() > currNum) {
                stack.pop();
                k--;
            }
            
            stack.push(currNum);
        }
        
        
        // if any left then
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        
        StringBuilder result = new StringBuilder();
        
        while(!stack.isEmpty())
            result.append(stack.pop());
        
        
        // since integer will reverse when poping 
        result.reverse();
        
        
        // Removing any leading zero
        while(result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);
            
        
        
        return result.toString();
    }
}
