class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // kth largest is the largest from the end of sorted array
        // i.e N - K + 1 from begining of the array.
        
        // Idea is to make a min heap that will store all the elements
        // then one by one we will get the kth largest element
        
        // if we have for example 1000 element and k = 3 then we have to remove
        // 997 elements to get that value, this is extra overhead in case of min heap.
        
        // so we can use max heap here which will give our element at N - K + 1 steps
        // or 4 steps.
        // so it can be used accordingly.
        
        // TC => n(N + Klogn)
        
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums)
            maxheap.add(num);
        
        int kth_largest = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++){
            kth_largest = maxheap.poll();
        }
        
        return kth_largest;
    }
}
