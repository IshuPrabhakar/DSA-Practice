class Solution {
    public int mySqrt(int x) {
        
        long left = 1, right = x, res = 0;
        // use long to avoid integer overflow
        
        
        while(left <= right){
            
            long mid = left + (right-left)/2;
            
            if(mid * mid == x){
               return (int)mid;
            }
            else if(mid * mid < x)
            {
                res = mid;
                left = mid + 1;
            }
            else if(mid*mid > x)
                right = mid - 1;
        }
        
        return (int)res;
    }
}
