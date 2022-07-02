class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // in this question we are making use of same array or modifying the same array
        // thats we don't need to carry another data structure for the modification
        
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(nums, res, 0);
        
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, int index){
        // Here we will make use of another data structure that will keep check of the duplicate element
        // if duplicate found we would simply skip that recursive call
        
        if(index >= nums.length){
            res.add(toList(nums));
            return;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = index; i < nums.length; i++){
            
            // check if the element for which we are calling is same as previous or not
            if(set.add(nums[i]) == false) continue; // if element is present in set then it will return false else true if not present
            
            swap(nums, index, i); // swapping to place next element at first place
            backtrack(nums, res, index + 1); // recursive call
            swap(nums, index, i); // backtrack step
        }
    }
    
    private List<Integer> toList(int[] nums){
        List<Integer> temp = new ArrayList<>();
        
        for(int i: nums)
            temp.add(i);
        
        return temp;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
