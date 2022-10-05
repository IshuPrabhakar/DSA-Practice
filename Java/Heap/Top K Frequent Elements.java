class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Approach is to hash elements in order to make frequency table
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        // Heap to get top k frequent elements from heap
        PriorityQueue<Map.Entry<Integer, Integer>> minheap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        // (a,b) -> a.getValue() - b.getValue() this bvasically camapare the frequency
        // of one element with other and will maintain entries in ASC. order
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minheap.add(entry);
            
            // maintaing only top k elements
            if(minheap.size() > k)
                minheap.poll();
        }
        
        int[] result = new int[k];
        
        for(int i = 0; !minheap.isEmpty(); i++){
            result[i] = minheap.poll().getKey();
        }
        
        return result;
    }
}
