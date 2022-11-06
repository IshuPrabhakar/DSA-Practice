class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // have to make boolean visited array to keep track of visited 
        // vertices because graph can be a type of disconnected graph
        boolean[] vis = new boolean[V];
        
        q.add(0);
        vis[0] = true;
        
        
        while(!q.isEmpty()){
            Integer vertex = q.poll();
            result.add(vertex);
            
            for(Integer i : adj.get(vertex)){
                if(vis[i] == false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        
        return result;
    }
}
