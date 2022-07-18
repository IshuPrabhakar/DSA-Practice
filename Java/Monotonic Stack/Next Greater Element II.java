class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        
        // Maintain Monotonic stack in decreasing order
        
        // Resultant list
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        
        // This is not synchronised hence it is more faster than stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n * 2; i++) {
            
            // this is to avoid index out of bound and also it rounds the
            // index such that it can never cross the boundary of array
            int num = nums[i % n];
            
            // compare if current element is greater then the peek of stack or not
            // if greater then insert into the res array
            while(!stack.isEmpty() && nums[stack.peek()] < num)
                res[stack.pop()] = num;
            
            // pushing elements into the stack
            if(i < n)
                stack.push(i);
        }
        
        return res;
    }
}
