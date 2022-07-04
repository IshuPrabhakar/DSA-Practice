class Solution {
    
    // To mark the position of placed Queens
    HashSet<Integer> col = new HashSet<>(); // this will mark the column in which Queen is placed
    HashSet<Integer> posDiagonal = new HashSet<>(); // this will mark the position in which Queen is placed diagonally from bottom-left to Top-right
    HashSet<Integer> negDiagonal = new HashSet<>(); // this will mark the position in which Queen is placed diagonally from Top-left to bottom-right
    
    public List<List<String>> solveNQueens(int n) {
        
        // Resultant List
        List<List<String>> result = new ArrayList<>();
        
        // To store current combination
        List<String> currentCombination = new ArrayList<>();
        
        // Actual function call
        backtrack(currentCombination, 0, n, result);
        
        return result;
    }
    
    private void backtrack(List<String> currentCombination, int row, int n, List<List<String>> result) {
        
        // Base case
        if(row == n){
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        
        for(int c = 0; c < n; c++) {
            
            int positive_diagonal = row - c;
            int negative_diagonal = row + c;
            
            // check if queen is placed or not
            if( col.contains(c) || posDiagonal.contains(positive_diagonal) || negDiagonal.contains(negative_diagonal) )
                continue;
            
            // Creates new char row where we are trying to place queens
            char[] q = new char[n];
            Arrays.fill(q,'.');
            q[c] = 'Q';
            
            // if Queen is place then mark it's position on the set like in which column it is placed 
            col.add(c);
            posDiagonal.add(positive_diagonal); // this will mark the bottom-left to top-right diagonal 
            negDiagonal.add(negative_diagonal); // this will mark the top-left to bottom-right diagonal 
            currentCombination.add(new String(q));
               
            backtrack(currentCombination, row + 1, n, result);
               
            currentCombination.remove(currentCombination.size()-1);
            col.remove(c);
            posDiagonal.remove(positive_diagonal);
            negDiagonal.remove(negative_diagonal);
        }
        
    }
}
