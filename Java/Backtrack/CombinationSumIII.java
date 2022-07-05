class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        // Rsultant list
        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(k, n, res, new ArrayList<>(), 1);
        
        return res;
    }
    
    private void backtrack(int k, int n, List<List<Integer>> res, List<Integer> curr, int count) {
        
        if(curr.size() == k){
            if(n == 0)
                res.add(new ArrayList<>(curr));
            return;
        }
        
        // i <= 9 because question says Only numbers 1 through 9 are used.
        for(int i = count; i <= 9; i++) {
            
            curr.add(i);
            // Here i + 1 should be used to avoid picking of the same element again and again 
            backtrack(k, n - i, res, curr, i + 1 );
            curr.remove(curr.size() - 1);
        }
    }
}
