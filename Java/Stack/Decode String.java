class Solution {
    public String decodeString(String s) {
        
        // Stack of counts
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>(); // this is not actuall result
        String curr = "";
        
        
        
        int index = 0;
        while(index < s.length()) {
            
            if(Character.isDigit(s.charAt(index))){
                // There can be two or more two digit numbers
                int curr_count = 0;
                while(Character.isDigit(s.charAt(index))) {
                    curr_count = curr_count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                count.push(curr_count);
            }
            else if(s.charAt(index) == '[') {
                
                // this is for initalisation purpose
                result.push(curr);
                curr = "";
                index++;
            }
            else if(s.charAt(index) == ']') {
                int times = count.pop();
                StringBuilder temp = new StringBuilder(result.pop());
                
                for(int i = 0; i < times; i++) {
                    temp.append(curr);
                }
                
                curr = temp.toString();
                index++;
            }
            else{
                curr += s.charAt(index);
                index++;
            }
        }
        
        return curr;
    }
}
