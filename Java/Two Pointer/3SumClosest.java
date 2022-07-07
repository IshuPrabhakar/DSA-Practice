class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        // Step 1: intialize result with three pointers
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        // sort the array
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                
                int sum = nums[left] + nums[right] + nums[i];
                
                if(sum < target)
                    left++;
                else
                    right--;
                
                // calculate the difference
                if(Math.abs(sum - target) < Math.abs(result - target)) {
                    
                    result = sum;
                }
            }
        }
        
        // return the result
        return result;
    }
}
