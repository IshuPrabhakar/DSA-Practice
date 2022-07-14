class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        // Edge case
        if( k <= 1)
            return 0;
        
        int product = 1;
        int pairs = 0;
        
        int left = 0;
        int right = 0;
        
        // Step 1: Calculate the product if product is >= to k
        // then decrease product move left and count pairs 
        while(right < nums.length) {
            
            product *= nums[right];
            
            while(product >= k && left < nums.length) {
                product /= nums[left++];
            }
            
            // Here right - left + 1 is done because 1 is for individual subarray
            // and right - left is the is another subarray
            pairs += right - left + 1;
            right++;
        }
        
        return pairs;
    }
}
