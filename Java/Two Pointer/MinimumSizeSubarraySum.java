class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        // Result
        int min_window = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        
        while(right < nums.length) {
            
            sum += nums[right];
            
            while(sum >= target){
                
                // calculating the window size untill we get minmum window
                min_window = Integer.min(min_window, right - left + 1);
                
                sum -= nums[left];
                left++;
            }
            // keep incrementing right pointer untill our sum is not greater than
            // or eqal to the target
            right++;
        }
        
        if(min_window == Integer.MAX_VALUE) return 0;
        
        return min_window;
    }
}
