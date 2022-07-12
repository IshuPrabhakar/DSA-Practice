//Runtime: 1 ms, faster than 83.69% of Java online submissions for Search in Rotated Sorted Array II.
//Memory Usage: 44.2 MB, less than 23.71% of Java online submissions for Search in Rotated Sorted Array II.

class Solution {
    public boolean search(int[] nums, int target) {
        
        int left = 0; 
        int right = nums.length-1;
        
        while(left <= right){
            
            // calcualating the mid point
            int mid = left + (right-left)/2;
            
            if(target == nums[mid]) 
                return true;
            
            // left sorted array
           else if(nums[left] < nums[mid]){
               
               // ex [3,4,5,6,1,2], target = 4
               if(target < nums[mid] && target >= nums[left])
                   right = mid-1;
               else
                   left = mid+1;
            }
            
            // right sorted part
            else if (nums[mid] < nums[left]){
                
                // ex [1,2,3,4,0], target = 4
                if(target > nums[mid] && target <= nums[right])
                    left = mid+1;
                else
                    right = mid-1;
            }
            
            // if duplicate element are encountered
            else{
                left++;
            }
        }
        
        return false;
    }
}
