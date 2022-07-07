class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length -1;
        int Left_Max = height[l], Right_Max = height[r];
        int totalWater = 0;
        
        while(l<r){
            if(Left_Max < Right_Max){
                l++;
                Left_Max = Integer.max(Left_Max,height[l]);
                totalWater += Left_Max - height[l];

            } 
            else{
                r--;
                Right_Max = Integer.max(Right_Max,height[r]);
                totalWater += Right_Max - height[r];
            }
        }
        
        return totalWater;
    }
}
