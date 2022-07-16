class Solution {
    public int totalFruit(int[] fruits) {
        
        // Longest sub array with 2 elements
        
        int first_fruit = -1;
        int second_fruit = -1;
        int first_fruit_count = 0;
        int second_fruit_count = 0;
        
        int curr_max = 0;
        int max_len = 0;
        
        for(int fruit : fruits) {
            
            if(fruit == first_fruit || fruit == second_fruit)
                curr_max++;
            else{
                // Actually resetting curr max to the second_fruit count + 1
                curr_max = first_fruit_count + 1;
            }
            
            // counting the first count
            if(fruit == first_fruit)
                first_fruit_count++;
            else
                first_fruit_count = 1;
            
            // updating the values
            if(fruit != first_fruit){
                second_fruit = first_fruit;
                first_fruit = fruit;
            }
            
            
            max_len = Math.max(max_len, curr_max);
        }
        
        return max_len;
    }
}
