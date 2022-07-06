class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        
        while(left <= right && top <= bottom){
            
            // traversing to the right
            for(int i = left; i <= right; i++){
                res.add(matrix[left][i]);
            }
            // decresing top because at this line we will have crossed top row 
            top++;
            
            // traversing to the bottom
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            
            // decresing right because at this line we will have crossed right most row 
            right--;
            
            // checking for single row matrix or single column matrix
            // i.e m*n = 1*0 or 0*1
            // if it is true then stop the further execution
            if (!(left <= right) || !(top <= bottom))
                break;
            
            // traversing to the left
            for(int i = right; i >= left; i--){
                res.add(matrix[bottom][i]);
            }
            
            // decresing bottom because at this line we will have crossed bottm row 
            bottom--;
            
            
            // traversing to the top
            for(int i = bottom; i >= top; i--){
                res.add(matrix[i][left]);
            }
            
            // decresing left because at this line we will have crossed left most row 
            left++;
        }
        
        return res;
    }
}
