class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        // Edge case
        if(matrix == null || matrix[0].length == 0 || matrix.length == 0)
            return 0;
        
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int maxArea = Integer.MIN_VALUE;
        int[] currRow = new int[m];
        
        for(int i = 0; i < m; i++) {
            currRow[i] = matrix[0][i] - '0';
        }
        
        // called with 0th row
        maxArea = Math.max(maxArea, maximumArea(currRow));
        
        //System.out.println(maxArea);
        
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < m; col++) {
                
                if(matrix[row][col] == '1')
                    currRow[col] += 1;
                else
                    currRow[col] = 0;
            }
            maxArea = Math.max(maxArea, maximumArea(currRow));
        }
        
        return maxArea;
    }
    
    
    private int maximumArea(int[] arr) {
        
        int n = arr.length;
        int maxArea = Integer.MIN_VALUE;
        
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        // for right boundary
        for(int currHeight = n - 1; currHeight >= 0; currHeight--) {
          
            if(stack.isEmpty())
                rightBoundary[currHeight] = n - 1;
            // Since smaller boundary cannot be rectangles boundary ex [3, 6, 5, 2]
            // for 6 we cannot choose 2 we have to choose 5
            // we need equal length boundary so - 1
            else {
                while(!stack.isEmpty() && arr[stack.peek()] >=  arr[currHeight])
                    stack.pop();
                
                rightBoundary[currHeight] = stack.isEmpty() ? n - 1 : stack.peek() - 1; 
            }
            stack.push(currHeight);
        }

        // reset stack
        stack.clear();
        
        
        for(int currHeight = 0; currHeight < n; currHeight++) {
            
            if(stack.isEmpty())
                leftBoundary[currHeight] = 0;
            // Since smaller boundary cannot be rectangles boundary ex [3, 6, 5]
            // for 5 we cannot choose 3 we have to choose 6
            // we need equal length boundary so + 1
            else{
                while(!stack.isEmpty() && arr[stack.peek()] >=  arr[currHeight])
                    stack.pop();
                
                leftBoundary[currHeight] = stack.isEmpty() ? 0 : stack.peek() + 1; 
            }
            stack.push(currHeight);
        }
        
        for(int currIndex = 0; currIndex < n; currIndex++) {

            int area = (rightBoundary[currIndex] - leftBoundary[currIndex] + 1) * arr[currIndex];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
