class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n = heights.length;
        
        // Stack for finding previous small and nex smaller elements
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        
        // This is for previous smaller
        int[] leftBoundary = new int[n];
        for(int currHeight = 0; currHeight < n; currHeight++) {
            
            if(stack.isEmpty())
                leftBoundary[currHeight] = 0;
            // Since smaller boundary cannot be rectangles boundary ex [3, 6, 5]
            // for 5 we cannot choose 3 we have to choose 6
            // we need equal length boundary so + 1
            else{
                while(!stack.isEmpty() && heights[stack.peek()] >=  heights[currHeight])
                    stack.pop();
                
                leftBoundary[currHeight] = stack.isEmpty() ? 0 : stack.peek() + 1; 
            }
            stack.push(currHeight);
        }

        // for resue of same stack
        stack.clear();
        
        // This is for previous smaller
        int[] rightBoundary = new int[n];
        for(int currHeight = n - 1; currHeight >= 0; currHeight--) {
          
            if(stack.isEmpty())
                rightBoundary[currHeight] = n - 1;
            // Since smaller boundary cannot be rectangles boundary ex [3, 6, 5, 2]
            // for 6 we cannot choose 2 we have to choose 5
            // we need equal length boundary so - 1
            else {
                while(!stack.isEmpty() && heights[stack.peek()] >=  heights[currHeight])
                    stack.pop();
                
                rightBoundary[currHeight] = stack.isEmpty() ? n - 1 : stack.peek() - 1; 
            }
            stack.push(currHeight);
        }
        
        
        // Calculating the maximum area
        // (rightBoundary - leftBoundary + 1 )* current height
        int maxArea = Integer.MIN_VALUE;
        for(int currHeight = 0; currHeight < n; currHeight++) {
            int currArea = (rightBoundary[currHeight] - leftBoundary[currHeight] + 1) * heights[currHeight];
            maxArea = Math.max(maxArea, currArea);
        }
        
        return maxArea;
    }
    
}
