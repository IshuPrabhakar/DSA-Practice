class Solution {
    public void nextPermutation(int[] nums) {
        
        // Approach is to find first decresing squence from right to left
        // then swap it with next higher number and then reverse the array
        
        // Step 1: first decresing squence from right to left
        int firstDecreasingSequenceIndex = -1;
        
        for(int i = nums.length-1 ; i > 0; i--){
            
            // finding decresing squence from right to left
            if(nums[i-1] < nums[i]){
                firstDecreasingSequenceIndex = i - 1;
                break;
            }
        }
        
        // finding the next higher value from firstDecreasingSequenceIndex to the end of array
        if(firstDecreasingSequenceIndex > -1)
        {
            for(int i = nums.length - 1; i > firstDecreasingSequenceIndex ; i--){
            
                if(nums[firstDecreasingSequenceIndex] < nums[i]){
                    // swapping function called to swap elements
                    swap(nums, firstDecreasingSequenceIndex, i);
                    break;
                }
            }
        }
        
        
        int right = nums.length - 1;
        int left = firstDecreasingSequenceIndex + 1;
        
        // if no decreasing sequence found then the array is sorted in th decreasing order
        // which means there will be no next permutation possible
        if(firstDecreasingSequenceIndex == -1)
            left = 0;
        
        // Now we need to reverse the array from the firstDecreasingSequenceIndex to the last
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    // swapping the elements
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
