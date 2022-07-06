class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0;
        int col = n-1;
        
        while(row < m && col > -1){
            
            if(matrix[row][col] == target)
                return true;
            
            if(target < matrix[row][col])
                col--;
            else
                row++;
        }
        
        return false;
    }
}
