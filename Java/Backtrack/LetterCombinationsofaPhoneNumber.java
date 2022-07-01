class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        //Edge case
        if(digits.length() == 0) return res;
                
        //letter mapping with the indices
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // calling the function
        combinations(res, map, new StringBuilder(), digits, 0);
        
        return res;
    }
    
    private void combinations(List<String> res, String[] map, StringBuilder curr, String digits, int index){
        
        // base case
        if(curr.length() == digits.length()){
            // At this point we have generated all the combinations/subsequences so add it to the result
            res.add(curr.toString());
            return;
        }
        
        int element = digits.charAt(index) - '0';
        String value = map[element];
        
        // Since input is a string and represent number which in turn represent strings
        // so we have to traverse through all the character of string represented by digits
        for(int i = 0; i < value.length(); i++){
            
            curr.append(value.charAt(i));
            combinations(res, map, curr, digits, index + 1); // recursive call
            curr.deleteCharAt(curr.length()-1); // this is backtracking step
            // since we are generating all the possible combination so we need to clear
            // the current output so that next combination can be generated
        }
        
    }
}
