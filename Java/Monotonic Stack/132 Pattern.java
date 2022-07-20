class Solution {
    public boolean find132pattern(int[] nums) {
        
        // Approch is that we will be making a monotonic decreasing stack
        // which will take care of jth and kth element
        // peek of the stack is the recent visited element
        
        // i.e if currently we are at i and we have visted jth index since we are
        // traversing backwards first we will traverse j then i
        // so from the stack recently inserted element becomes our j
        // and elements before that becomes our k element which we will store in second named varible
        
        // Now our stack is taking care of j and k we now only need to find if current element is less
        // kth element or not that is our second variable since kth elemet is poped out last from stack
        // ith element is less than kth then it is obvious that it would also less than jth
        // if it is true then we found our anser :)
        
        // Monotonic decresing 
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;
        
        for(int curr = nums.length - 1; curr >= 0; curr--) {
            
            if (nums[curr] < second)
                return true;
            
            while(!stack.isEmpty() && nums[curr] > stack.peek())
                second = stack.pop();
                
            stack.push(nums[curr]);
        }
        
        return false;
    }
}
