class Solution {
    public int maxSubArray(int[] nums) {
        
        // This approach is also known as Kadane's Algorithm
        
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
      
        for(int i = 0; i < nums.length; i++) {
            
            // calcullating the current sum
            curr_sum += nums[i];
            
            if(curr_sum > max_sum)
                max_sum = curr_sum;
            
            // if get any negative number which result in overall negative sum then
            // we discard that whole part by making curr_sum = 0
            // Now , we will start calculating sum from the next index or from the
            // positve integer
            if(curr_sum < 0)
                curr_sum = 0;
        }
        
        return max_sum;
    }
}
