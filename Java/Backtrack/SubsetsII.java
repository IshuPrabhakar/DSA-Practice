class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        
        // Arrange all duplicate in order so that skiping duplicate becomes more easy
        Arrays.sort(nums);
        
        backtrack(nums, res, new ArrayList<Integer>(), 0);
        
        return res;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> curr, int index) {
        
        // Base case
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        curr.add(nums[index]);
        backtrack(nums, res, curr, index + 1);
        // Backtrack step
        curr.remove(curr.size() - 1);
        
        // Skipping all the duplicates if we had skipped first element
        while(index + 1 != nums.length && nums[index] == nums[index + 1]) index++;
        
        backtrack(nums, res, curr, index + 1);
    }
}
