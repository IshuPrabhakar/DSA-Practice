class MedianFinder {

    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    private boolean isEven;
    
    // Approach is to store stream in min and max heap
    // so that we can easily get or max and min elements.
    
    // In median we basically require meddile element to compute median
    // so the idea comes from this if we divede stream such that
    // we will store max element in min heap so that it can give max from
    // first half, and same for second half.
    
    // Here we take the first scenario for example, we know the large will gain one more
    // item and small will remain the same size, but we cannot just push the item into
    // large. What we should do is we push the new number into small and pop the maximum
    // item from small then push it into large (all the pop and push here are heappop and
    // heappush). By doing this kind of operations for the two scenarios we can keep our invariant.
    // Therefore to add a number, we have 3 O(log n) heap operations. Luckily the heapq
    // provided us a function "heappushpop" which saves some time by combine two into one. 
    
    // Resource => https://leetcode.com/problems/find-median-from-data-stream/discuss/74047/JavaPython-two-heap-solution-O(log-n)-add-O(1)-find
    
    public MedianFinder() {
        this.minheap = new PriorityQueue<>(); // for second half
        this.maxheap = new PriorityQueue<>(Collections.reverseOrder()); // for first half
        this.isEven = true;
    }
    
    public void addNum(int num) {

        if (isEven){
            minheap.add(num);
            maxheap.add(minheap.poll());
        }
        else {
            maxheap.add(num);
            minheap.add(maxheap.poll());
        }
        
        isEven = !isEven;
    }
    
    public double findMedian() {
        
        if (isEven){
            return (maxheap.peek() + minheap.peek()) / 2.0;
        }
        else
            return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
