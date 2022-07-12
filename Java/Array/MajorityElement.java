class Solution {
    public int majorityElement(int[] nums) {
        
        //Boyer-Moore Voting Algorithm
        
        int majority = nums[0], count = 0;
        
        for(int i = 0; i < nums.length; i++){
             if(count == 0)
            {
                majority = nums[i];
            }
            
            if(majority == nums[i])
                count++;
            else
                count--;
            
        }
        return majority;
    }
}
