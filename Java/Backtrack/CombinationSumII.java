class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        
        // to store current formed subset
        List<Integer> curr = new ArrayList<>();
        
        // sorting is done here basically to move all the duplicates aside in order
        Arrays.sort(candidates);
        
        backtrack(candidates, res, target, 0, curr);
        
        return res;
    }
    
    private void backtrack(int[] candidates, List<List<Integer>> res, int target, int index, List<Integer> curr) {
        
        // Base case
        if(index == candidates.length){
            // add to the res if we get the required sum else simply return
            if(target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        
        
        if(candidates[index] <= target){ 
            curr.add(candidates[index]);
            backtrack(candidates, res, target - candidates[index], index + 1, curr);
            // if we are not picking any element then we should not subtract curr with our target
            curr.remove(curr.size() - 1); // bactrack step
        }
        
        // if we found any duplicate the simply skip that
        while(index + 1 < candidates.length && candidates[index] == candidates[index + 1]) index++;
        
        backtrack(candidates, res, target, index + 1, curr);
    }
}
