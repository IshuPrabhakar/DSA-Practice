class Solution {
    public int triangleNumber(int[] nums) {
        
        // Edge cases
        if(nums.length <= 2) 
            return 0;
        
        int count = 0;
        
        Arrays.sort(nums);
        
        // c is intialized at the end of the array so that a + b can be greater then c then we will add this to our count
        for(int c = nums.length - 1; c > 1; c--) {
            
            // b is initialized at right before c so we can compare numbers from a to b at single step
            for(int a = 0, b = c - 1; a < b;) {
                
                if(nums[a] + nums[b] > nums[c]){
                    count += b - a; // because from a to b there will be b - a combinations which are going to form triangle because array is sorted then we can surely say this
                    b--;
                }
                else
                    a++;
            }
        }
        
        return count;
    }
}

// Refer: https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
