class Solution {
    public String decodeString(String s) {
        
        // Stack of counts
        Stack<Character> stack = new Stack<>();
        String result = "";     
        
        int index = 0;
        while(index < s.length()) {
            
            if(s.charAt(index) == ']'){
                
                String temp = new String();
                
                // here we are getting string
                while(stack.peek() != '['){
                    temp = stack.pop() + temp;
                }
                // this wiil pop '[' from the stack
                stack.pop();
                
                // use string because 100 will be come 001 when it comes from stack
                // times = imes * 10 + stack.pop() will won't work
                String times = "";
                
                // here we are getting digits from the string 
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    times = stack.pop() + times;
                }

                // another temppray string is used to avoid any string immutiblity issues
                StringBuilder curr = new StringBuilder();
                
                // here we are multiplying string numbers of times
                for(int i = 0; i < Integer.valueOf(times); i++){
                    curr.append(temp);
                }
                
                for(char c : curr.toString().toCharArray())
                    stack.push(c);
            }
            else{
                stack.push(s.charAt(index));
            }
            index++;
        }
        
        while(!stack.isEmpty())
            result = stack.pop() + result;
        
        return result;
    }
}
