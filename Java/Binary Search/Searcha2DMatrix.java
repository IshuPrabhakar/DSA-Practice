class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Approch is to visualise 2d array as 1d/linear array
        // then we have to map each index with its corresponding row and column index
        
        int left = 0;
        int right = m*n - 1;
        
        while(left <= right){
            
            int mid = left + (right-left)/2;
            
            // mid/n will give number of row it lies in
            // mid%n will give number of column it lies in
            if (target == matrix[mid/n][mid%n])
                return true;
            
            if(target > matrix[mid/n][mid%n])
                left = mid+1;
            else
                right = mid-1;                
        }
        
        return false;
    }
}
