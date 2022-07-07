class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new LinkedList<>();
        
        // sort the array
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++){
            
            // checking duplicates
            // i > 0 && nums[i] == nums[i-1]
            // continue
            if( i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int r = nums.length-1, l = i + 1;
                // a + b + c = 0
                // b + c = 0 - a
                int sum = 0 - nums[i];

                while(l < r){

                    if(nums[l] + nums[r] == sum){
                        // adding to the result
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                        // update the pointers
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(r > 0 && nums[r] == nums[r-1]) r--;

                        l++;
                        r--;

                    }

                    else if(nums[l] + nums[r] < sum) l++;
                    else r--;
                }
            }
            
        }
        
        return res;
    }
}
