class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        // hashmap is to store the values
        HashSet<String> set = new HashSet<>();
        
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                
                // the trick or approach is that when adding elements into the hashset
                // it returns false if element is present in hashset
                // we made it true by "!" adding this 
                // if it true the return false
                
                // here we used string is to store all the characters uniquely
                // which ensure that there is no duplicates in the range
                // of 3x3 matrix or box
                // and allow in other boxes other than itself
                char value = board[row][col];
                if (value != '.'){
                    
                    if(!set.add(value + "Found in col" + col) ||
                       !set.add(value + "Found in row" + row) ||
                       !set.add(value + "Found in sub box " + row/3 +" "+ col/3))
                         return false;
                }          
               
            }
        }
        
        return true;
    }
}

// Approch 2 solution https://leetcode.com/problems/valid-sudoku/discuss/15464/My-short-solution-by-C%2B%2B.-O(n2)
