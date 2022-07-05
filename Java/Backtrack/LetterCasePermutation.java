class Solution {
    public List<String> letterCasePermutation(String s) {
        // Resultant list
        List<String> res = new ArrayList<>();
        
        backtrack(res, s, s.toCharArray(), 0);
        
        return res;
    }
    
    private void backtrack(List<String> res, String s, char[] curr, int index) {
        
        //Base case
        if(index == s.length()){
            res.add(new String(curr));
            return;
        }


        // by using char array we get the advantage that every time we don't have to append and delete
        // characters in a string or stringbuilder
        // in conatrast to that it becomes easy to skip if any number found int the string
        // as string or char array is already made and we are just modifying it so no need to have
        // extra data structure
        if(Character.isLetter(curr[index])) {
            // Make first call for uppercase 
            curr[index] = Character.toUpperCase(curr[index]);
            backtrack(res, s, curr, index + 1);

            // Make call for lowercase 
            curr[index] = Character.toLowerCase(curr[index]);
            backtrack(res, s, curr, index + 1);
        }
        else {
            // if it is a letter then skip it
            backtrack(res, s, curr, index + 1);
        }
            
 
    }
}
