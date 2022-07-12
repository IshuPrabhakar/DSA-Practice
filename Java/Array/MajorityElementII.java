class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        // Bore moore voting machine algorithm with two elements
        // length of the array
        int length = nums.length;
        
        // Resultant array
        List<Integer> res = new ArrayList<>();
        
        int count1 = 0, count2 = 0;
        int majority1 = -1, majority2 = -1;
        
        for(int i = 0; i < nums.length; i++) {
            
            if(majority1 == nums[i])
                count1++;
            
            else if(majority2 == nums[i])
                count2++;
            
            else if(count1 == 0) {
                majority1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                majority2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        // Check if they actually are majority elements
        count1 = count2 = 0;
        
        for(int i : nums){
            
            if(majority1 == i)
                count1++;
            else if(majority2 == i)
                count2++;
        }
        
        // Check if those majority elements are greater then length/3
        if(count1 > length/3)
            res.add(majority1);
        
        if(count2 > length/3)
            res.add(majority2);
        
        return res;
    }
}
