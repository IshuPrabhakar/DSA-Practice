class Solution {
    public int calculate(String s) {
        
        // Stack to store previous result
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int length = s.length();
        
        int result = 0;
        int sign = 1;
        
        for(int i = 0; i < length; i++) {

            if (Character.isDigit(s.charAt(i))) {
                
                int curr_num = s.charAt(i) - '0';
                // number can be of more one digit
                while(i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                     curr_num = curr_num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }

                // once we get a new number then we add it with the previous result
                // as it is multipied with sign so no need to worry we can simpy add it
                // to our result
                curr_num *= sign;
                result += curr_num;
                
                // reset all the values once evalution completes
                curr_num = 0;
                sign = 1;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-') {
                sign = -1;
            }
            else if(s.charAt(i) == '(') {
                
                // if we see an opening parenthesis that mean now we have to evalute
                // the expression that is inside the parenthesis for that we have to save 
                // our previous result to the stack along with the previous sign
                // ex 1 - ( 2 + 5)
                
                stack.push(result);
                stack.push(sign);
                
                // reset the variables to store next expresion
                result = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')') {
                // at this stage we have completed evaluation of expression that was inside the
                // parenthesis now pop out the sign and previous result
                //  1 - (2 + 5)
                result = result * stack.pop() + stack.pop();
            }
        }
        
        return result;
    }
}
