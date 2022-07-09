class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int l = 0, r = arr.length-1;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            
            // If nums[mid] < nums[mid + 1] then obviously our result will lie in the right part of the mid, 
            // because this condition tells us that this part is increasing so search in the other part of the array.

            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        return l;
    }
}
