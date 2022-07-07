class Solution {
    public int maxArea(int[] height) {
        int max = height[0], i=0,j = height.length-1;
        int maxArea = 0;
        
        while(i < j){
            maxArea = Integer.max(maxArea, Integer.min(height[i],height[j])*(j-i));
            
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        
        return maxArea;
    }
}
