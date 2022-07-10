class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int length = nums.length;
        // marking every negative number to zero
        for(int i = 0; i < length; i++) {
            
            if(nums[i] < 0)
                nums[i] = 0;
        }
        
        // Marking existed integers
        for(int i = 0; i < length; i++) {
            
            int index = Math.abs(nums[i]);
            
            // checking if integer are out of bound
            if(index >= 1 && index <= length) {

                if(nums[index - 1] > 0)
                    nums[index - 1] *= -1;
                
                else if(nums[index - 1] == 0)
                    nums[index - 1] = -1 * (length + 1);
            }
            
        }
        
        // checking again if smallest value appear or not
        // if appered then check for next smallest
        for(int i = 1; i <= length; i++) {
            
            if(nums[i - 1] >= 0 )
                return i;
        }
        
        return length + 1;
    }
}
