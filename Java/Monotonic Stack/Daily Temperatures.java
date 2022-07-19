class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int length = temperatures.length;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // Resultant Array
        int[] res = new int[length];
        
        for(int currDay = 0; currDay < length; currDay++) {
            
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currDay]) {
                
                // current index - index stored in the stack
                int previousDay = stack.pop();
                res[previousDay] = currDay - previousDay;
            }
            
            stack.push(currDay);
        }

        
        return res;
    }
}
