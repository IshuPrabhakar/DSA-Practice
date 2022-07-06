class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                
                // if at any point we found empty cell 
                if(board[row][col] == '.') {
                    
                    for(char c = '1' ; c <= '9' ; c++) {
                        
                        if(isValid(board, row, col, c)) {
                            board[row][col] = c;
                            
                            if(solve(board))
                                return true;
                            else
                                board[row][col] = '.'; // backtrack step
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int row , int col, char c){
        
        for(int i = 0; i < 9; i++){
            
            // for row
            if(board[row][i] == c)
                return false;
            
            if(board[i][col] == c)
                return false;
            
            // Sub matrix
            int sub_row = 3 * (row / 3) + i / 3;
            int sub_col = 3 * (col / 3) + i % 3;
            
             if(board[sub_row][sub_col] == c)
                return false;
        }
        
        return true;
    }
}
