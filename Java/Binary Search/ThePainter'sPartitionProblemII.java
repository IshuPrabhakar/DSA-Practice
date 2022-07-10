class Solution{
     
    public static long numberOfPainter(int[] arr, long mid){
        
        long painter = 1;
        long totalTime = 0;
        
        for(int i = 0; i < arr.length; i++){
            totalTime += arr[i];
            
            if(totalTime > mid){
                painter++;
                totalTime = arr[i];
            }
        }
        
        return painter;
    }
    
    static long minTime(int[] arr,int n,int k){
        //code here
        
        long totalTime = 0;
        long left = 0;
        
        // calculating max time required by painters if one painter 
        // is painting entire board
        // max of the array is the minimum time required to paint board
        // by the painter
        for(int i = 0; i < n; i++){
            left = Math.max(left, arr[i]);
            totalTime += arr[i];
        }
        
        long right = totalTime;
        
        // check wheather the solution can lie between 
        // max of array to total time
        while(left <= right){
            
            long mid = left + (right-left)/2;
            
            long painterRequired = numberOfPainter(arr, mid);
            
            if(painterRequired <= k)
                right = mid-1;
            else
                left = mid+1;
        }
        
        return left;
        
    }
}


