class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        // Resultant list
        List<List<Integer>> res = new ArrayList<>();
        
        // to store current result
        List<Integer> curr = new ArrayList<>();
        
        // Actuall funtion call
        backtrack(res, curr, 1, n, k );
        
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int start, int n, int k) {
        // if current combination size is equal to k then add it to the result 
        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
            
        
        for(Integer i = start; i <= n; i++){
            curr.add(i);
            backtrack(res, curr, i + 1, n, k ); // start = i + 1 because previously we made combinations of that now we move to next with for loop
            // i.e if i = 1 + 1 => 2 then we made all the combinations
            // after returning i == 2 + 1 => 3 now will make combination of 3 
            curr.remove(i); // backtrack step
        }
        
    }
}
