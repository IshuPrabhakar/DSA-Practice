class Solution {
    public String frequencySort(String s) {
        
        // Same as 374 Top k Frequent
        
        // Create frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c , map.getOrDefault(c, 0) + 1);
        }

        
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>( (a,b) -> b.getValue() - a.getValue());
        heap.addAll(map.entrySet());
        
        StringBuilder ans = new StringBuilder();
        
        while(!heap.isEmpty()){
            Map.Entry e = heap.poll();
            
            for(int i = 0; i < (int)e.getValue(); i++)
                ans.append(e.getKey());
        }
        
        return ans.toString();
    }
}
