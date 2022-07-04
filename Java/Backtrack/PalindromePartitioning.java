class Solution {
    public List<List<String>> partition(String s) {
        
        // Resultant List
        List<List<String>> res = new ArrayList<>();
        
        // To store current combination
        List<String> currentCombination = new ArrayList<>();
        
        backtrack(res, currentCombination, s, 0);
        
        return res;
    }
    
    private void backtrack(List<List<String>> res, List<String> currentCombination, String s, int start) {
        
        if(start == s.length()){
            // if we reach the end that means we have found a valid combination
            res.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            
            if(isPalindrome(s, start, i)) {
                
                currentCombination.add(s.substring(start, i + 1));
                backtrack(res, currentCombination, s, i + 1);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        // it checks if string is palindrome or not
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        
        return true;
    }
}
