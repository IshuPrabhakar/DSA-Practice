class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        // This is the reulted list
        List<List<Integer>> res = new ArrayList<>();
        
        // this is for tempory puspose
        List<Integer> temp = new ArrayList<>();
        
        // this is the converted list for ease of operation
        List<Integer> convertedNums = new ArrayList<>();
        // Converting nums to list
        convertedNums = toList(nums);
        
        // Actual function call
        power(convertedNums, res, 0, temp);
        
        return res;
    }
    
    public void power(List<Integer> nums, List<List<Integer>> res, int index, List<Integer> temp){

        // Base case
        if(index >= nums.size()){
            res.add(new ArrayList(temp));
            return;
        }
        
        temp.add(nums.get(index)); // this will pick an element from the list
        power(nums, res, index + 1, temp); // this call is with the picked element
        temp.remove(nums.get(index)); // this will remove that element from the list
        power(nums, res, index + 1, temp); // this call is without the picked element
    }
    
    // Function to convert int array to list
    public List<Integer> toList(int[] nums){
        List<Integer> res = new ArrayList<>();
        
        for(int i: nums)
            res.add(i);
        
        return res;
    }
}
