class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        //## More the weight, lesser the days required
        
        // minimum weight capacity of the ship
        long min_limit = 0;
        
        // maximum weight capacity of the ship
        long max_limit = 0;
        
        for(int i = 0; i < weights.length; i++) {
            
            // this will be the maximum weight capacity of the ship
            max_limit += weights[i];
            
            // this will be the minimum capacity of the ship
            min_limit = Math.max(weights[i], min_limit);
        }
        
        
        while(min_limit <= max_limit) {
            
            long mid = min_limit + (max_limit - min_limit)/2;
            
            long days_req = daysRequired(weights, mid);
                
            if(days_req <= days){
                max_limit = mid - 1;
            }
            else
                min_limit = mid + 1;
        }
        
        return (int)min_limit;
        
    }
    
    private int daysRequired(int[] weights, long capacity) {
        
        // Always intialise it with 1
        int days = 1;
        
        long sum = 0;
        for(int i = 0; i < weights.length; i++) {
            
            sum += weights[i];
            
            // Always use > symbol not >= else it will produce wrong result
            if(sum > capacity) {
                days++;
                sum = weights[i];
            }
        }
        
        return days;
    }
}
