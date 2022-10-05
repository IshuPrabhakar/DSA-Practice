class Solution {
    public int lastStoneWeight(int[] stones) {
        
        // Idea is to store all the values in max heap because we have to choose
        // two haviest stone each time and the datastructre to achieve is max heap
        
        // Build a max heap
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone : stones)
            maxheap.add(stone);
        
        int first_stone = 0;
        int second_stone = 0;
        
        while(maxheap.size() > 1){
            
            first_stone = maxheap.poll();
            second_stone = maxheap.poll();
            
            if(second_stone != first_stone)
                maxheap.add(first_stone - second_stone);
        }
        
        if(maxheap.size() > 0)
            return maxheap.poll();
        
        return 0;
    }
}
