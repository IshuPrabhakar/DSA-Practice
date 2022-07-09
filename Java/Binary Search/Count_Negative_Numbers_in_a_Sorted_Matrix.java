class Solution {
    public int countNegatives(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int row = 0;
        int col = n - 1;
        
        int count = 0;
        
        while(row < m && col >= 0) {
            
            // we are searching for negative element downwards
            // starting from top right if 1st element is negative then it is 
            // obvious entire column will contain negaitve elements
            // so add it to the result
            if(grid[row][col] < 0) {
                count += m - row;
                col--;
            }
            else
                row++;
        }
        
        return count;
    }
}
