class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;
        int count = 1;
        
        // Approch is to simulate what the problem says
        // Do remember proper updatation of variables
        // ex if going from top to left increment top++
        // if going from bottom to top decrement it
        
        while(left <= right && top <= bottom){
            
            // top side i.e from left to right
            for(int i = left; i <= right; i++){
                res[top][i] = count++;
            }
            top++;
            
            // right side i.e from top to bottom
            for(int i = top; i <= bottom; i++){
                res[i][right] = count++;
            }
            right--;
            
            // bottom side i.e from right to left
            for(int i = right; i >= left; i--){
                res[bottom][i] = count++;
            }
            bottom--;
            
            // left side i.e from bottom to top
            for(int i = bottom; i >= top; i--){
                res[i][left] = count++;
            }
            left++;
        }
        
        return res;
    }
}
