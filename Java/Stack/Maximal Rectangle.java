class Solution {
    public int maximalRectangle(char[][] matrix) {
       
        int n = matrix.length;
        int m = matrix[0].length;
        
        int maxArea = Integer.MIN_VALUE;
        int[] currRow = new int[m];
        
        for(int i = 0; i < n; i++) {
            currRow[i] = matrix[0][i] - '0';
        }
        
        // called with 0th row
        maxArea = Math.max(maxArea, maximumArea(currRow));
        
        for(int row = 1; row < n; row++) {
            for(int col = 0; col < m; col++) {
                
                if(matrix[row][col] == '1')
                    currRow[col] += 1;
                else
                    currRow[col] = 0;
            }
            maxArea = Math.max(maxArea, maximumArea(currRow));
            //System.out.print(maxArea + " ");
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
        for(int currIndex = 0; currIndex < n; currIndex++) {
            
            if(stack.isEmpty()) {
                rightBoundary[currIndex] = n - 1;
            }
            else{
                 while(!stack.isEmpty() && arr[stack.peek()] >= arr[currIndex]) {
                    rightBoundary[stack.pop()] = currIndex; // currIndex - 1
                }
                // if we can't find next element then we simply add curr index in result
                rightBoundary[currIndex] = currIndex;
            }
            stack.push(currIndex);
        }
        
        // reset stack
        stack.clear();
        
        
        for(int currIndex = n - 1; currIndex >= 0; currIndex--) {
            
            if(stack.isEmpty()) {
                leftBoundary[currIndex] = 0;
            }
            else{
                 while(!stack.isEmpty() && arr[stack.peek()] >= arr[currIndex]) {
                    leftBoundary[stack.pop()] = currIndex; // currIndex + 1
                }
                // if we can't find next element then we simply add curr index in result
                leftBoundary[currIndex] = currIndex;
            }
            stack.push(currIndex);
        }
        
        
        for(int currIndex = 0; currIndex < n; currIndex++) {

            int area = (rightBoundary[currIndex] - leftBoundary[currIndex] - 1) * arr[currIndex];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}
