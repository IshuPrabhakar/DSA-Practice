//Runtime: 1 ms, faster than 83.18% of Java online submissions for Remove Duplicates from Sorted Array II.
//Memory Usage: 44.8 MB, less than 40.17% of Java online submissions for Remove Duplicates from Sorted Array II.

class Solution {
    public int removeDuplicates(int[] nums) {
        
        // edge case
        if(nums.length <= 1) return nums.length;
        
        int count = 0;
        
        for(int i = 0; i < nums.length-1; i++){
            
            // if curr element is not equal than next element then add it 
            if(nums[i] < nums[i+1]){
                 nums[count++] = nums[i];
            }
            else{
                // if both are same then add it twicw since problem states that
                // we can add each element atmost twice
                nums[count++] = nums[count++] = nums[i];
                // increment i index till current element is same as next element
                while(nums[i] == nums[i+1] && i + 1 < nums.length-1) i++;
            }
            
            // since we are traversing till nums.length-1 the last element
            // is left to check so add this, this line will add it at the end
            // if 2nd last element is not same as last element
            // else it will make 3 duplicates of last element
            if(i + 1 == nums.length-1 && nums[i] != nums[i+1])
                nums[count++] = nums[nums.length-1];
        }
        
                
        return count;
    }
}
