class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0;
        
        int max_len = 0;
        int zeros = 0;
        
        // Similar to longest character repalcement
        
        // Count zero insteed of ones as here because
        // only two values are used in which we have to flip zeros to ones 
        // so counting zeros makes more sense
        
        for(int right = 0; right < nums.length; right++) {
            
            // count zeros
            if(nums[right] == 0)
                zeros++;
            
            if(zeros > k) {
                if(nums[left] == 0)
                    zeros--;
                left++;
            }
            
            max_len = Math.max(max_len, right - left + 1);
        }
        
        return max_len;
    }
}
