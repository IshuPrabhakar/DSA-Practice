class Solution {
    
    // result
    int result;
    
    HashSet<Integer> col = new HashSet<>();
    HashSet<Integer> posDiagonal = new HashSet<>();
    HashSet<Integer> negDiagonal = new HashSet<>();
    
    public int totalNQueens(int n) {
        // declare result variable global and intialise it in function else will produce wrong answer
        // don't pass through parameter else it will be reset after every function call
        result = 0;
        
        backtrack(n, 0);
        
        return result;
    }
    
    private void backtrack(int n, int row) {
        
        if(row == n){
            result++; // if we reach at this end it means we have found a solution
            return ;
        }
        
        for(int c = 0; c < n; c++){
            
            int postive_diagonal = row - c;
            int negative_diagonal = row + c;
            
            if( col.contains(c) || posDiagonal.contains(postive_diagonal) || negDiagonal.contains(negative_diagonal) )
                continue;
            
            col.add(c);
            posDiagonal.add(postive_diagonal);
            negDiagonal.add(negative_diagonal);
            
            backtrack(n, row + 1);
            
            col.remove(c);
            posDiagonal.remove(postive_diagonal);
            negDiagonal.remove(negative_diagonal);
        }
    }
}
