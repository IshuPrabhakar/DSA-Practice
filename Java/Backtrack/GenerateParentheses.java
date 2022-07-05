class Solution {
    public List<String> generateParenthesis(int n) {
        // To be more clear make decison tree then it'll be more clear to you
        
        // Resultant List
        List<String> res = new ArrayList<>();
        
        // Paranthesis count
        int open = 0;
        int close = 0;
        
        backtrack(n, res, "", open, close);
        
        return res;
    }
    
    private void backtrack(int n, List<String> res, String curr, int open, int close) {
        
        if(open == n && close == n){
            res.add(curr.toString());
            return;
        }
        
        if(open < n) // without opening parenthesis we cannot close so we check here
            backtrack(n, res, curr + "(", open + 1, close);
        if(close < open) // close should be less than open because if we not open bracket then how can we close
            backtrack(n, res, curr + ")", open, close + 1);
    }
}
