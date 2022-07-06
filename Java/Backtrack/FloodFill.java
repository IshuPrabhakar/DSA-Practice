class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        fill(image, sr, sc, color, image[sr][sc]);
        
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int color, int oldColor) {
        
        if(sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != oldColor || image[sr][sc] == color)
            return;
        
        if(image[sr][sc] == oldColor) {
            
            
            image[sr][sc] = color;
            // top
            fill(image, sr - 1, sc, color, oldColor);
            
            // right
            fill(image, sr , sc + 1, color, oldColor);
            
            // bottom
            fill(image, sr + 1, sc, color, oldColor);
            
            // left
            fill(image, sr, sc - 1, color, oldColor);
        }
    }
}
