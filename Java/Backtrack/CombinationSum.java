class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        
        // Temporary data structure to carry current combination
        List<Integer> curr = new ArrayList<>();
        
        
        findCombination(candidates, target, res, curr, 0);
        
        return res;
    }
    
    public void findCombination(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int index) {
        
        // Base case
        if(index == candidates.length){
            
           // add to the res if we get the required sum else simply return 
            if(target == 0){
                res.add(new ArrayList<>(curr));
            }
            return;
        }
        
        // if current element is less than target then only we need to add else stop further function call
        if(candidates[index] <= target){
            
            curr.add(candidates[index]); // this is picking the element
            findCombination(candidates, target - candidates[index], res, curr, index); // this wil choose current element 
            // Backtrack step
            curr.remove(curr.size()-1); // this is removing the same element that was picked
        }
        findCombination(candidates, target, res, curr, index + 1);
    }
}
