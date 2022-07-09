class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            
            int temp = max;
            
            max = Math.max( Math.max(max * nums[i], nums[i]), min * nums[i]);
            
            min = Math.min( Math.min(temp * nums[i], nums[i]), min * nums[i]);
            
            ans = Math.max(ans, max);
        }
        
        return ans;
    }
}
