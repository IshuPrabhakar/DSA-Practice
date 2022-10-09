class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        // Approach is to use min heap here
        // we will store the elements of array in the min heap
        // then we will increment minimum element k times
        
        // at last multiply all and return the result
        
        long mod = 1000000007;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        
        // Add all elements into the heap
        for(int num : nums)
            minheap.add(num);
        
        // Increment minimum element k times
        for(int i = 0; i < k; i++){
            
            int num = minheap.poll();
            minheap.add(num + 1);
        }
        
        long product = minheap.poll();
        while(!minheap.isEmpty())
            product = (product * minheap.poll()) % mod;
        
        
        return (int)product;
    }
}
