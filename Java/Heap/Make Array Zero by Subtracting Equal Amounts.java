import java.util.*;
class Solution {
    public int minimumOperations(int[] nums) {
        
        // Approach #1 is to keep track of minimum elements in min heap
        // then subtract each element by min of heap.
        // TC => O(n + nlogn) => nlogn
        
        // However there is more intuative is also availble i.e.
        // number of minimum number of operations to make every element 0
        // is equal to the no. of unique element present in array..
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int count = 0;
        
        for(int num : nums)
            if(num > 0)
                minheap.add(num);
        
        while(!minheap.isEmpty()){
            int min = minheap.poll();
            
            // clear min heap to store new minimum elements after subtraction
            minheap.clear();
            
            for(int i = 0; i < nums.length; i++){
                nums[i] -= min;
                if(nums[i] > 0)
                    minheap.add(nums[i]);
            }
            
            count++;
        }
        
        return count;
    }
}
