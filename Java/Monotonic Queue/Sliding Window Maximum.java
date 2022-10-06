class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // Approach is to use Deque (Queue or Dobly linked list) 
        // and Maintain a decreasing queue so that the maximum element
        // of that sliding window will present at the front of queue.
        
        int size = nums.length;
        int[] result = new int[size - k + 1];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        int left = 0;
        for(int index = 0; index < size; index++){
            
            // Remove the out of range elements
            if(!q.isEmpty() && q.peek() < index - k + 1 ){
                q.poll();
            }
            
            // Remove the smaller elements from the tail of the queue
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[index])
                q.pollLast();
            
            q.offer(index);
            
            if(index >= k - 1)
                result[left++] = nums[q.peek()];
        }
        
        return result;
    }
}
