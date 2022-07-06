class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // aditional variable is to mark first row
        boolean topLeftZero = false;
 
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                
                // mark every row and colunm with zero that contains zero in it
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    // if it is not first row
                    if(i > 0)
                        matrix[i][0] = 0;
                    else
                        topLeftZero = true;
                }
            }
        }
        
        
        // making zero to the elements that has marked as zero
        // skiping first row and colunm
        for(int i = 1; i < m ; i++){
            for(int j = 1; j < n ; j++){
                // if and only if row and column marked as zero 
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        
        
        
        
        if(matrix[0][0] == 0){
            //if first value i.e (0,0) is zero then set entire colunm zero
            for(int i = 0; i < m ; i++){
                matrix[i][0] = 0;
            }
        }
        
        // if topleft value is marked zero then make entire row to zero
        if(topLeftZero){
            for(int i = 0; i < n ; i++){
                matrix[0][i] = 0;
            }
        }
        
        
    }
}
