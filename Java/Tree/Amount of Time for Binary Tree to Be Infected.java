/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int start;
    private TreeNode startNode = null;
    
    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        
        if(root != null && root.left == null && root.right == null)
            return 0;
        
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        mapParent(root, map);
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> isVisited = new HashSet<>();
        q.offer(startNode);
        
        int minutes = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                isVisited.add(curr);

                if(map.containsKey(curr) && !isVisited.contains(map.get(curr)))
                    q.offer(map.get(curr));
                
                if(curr.left != null && !isVisited.contains(curr.left))
                    q.offer(curr.left);
                
                if(curr.right != null && !isVisited.contains(curr.right))
                    q.offer(curr.right); 
            }
            
            minutes++;
        }
        
        return minutes - 1;
    }
    
    // TC => O(nlogn)
    private void mapParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        
        if(root == null)
            return;
        
        // Finding start node as well
        if(root.val == start)
            startNode = root;
        
        if(root.left != null)
            map.put(root.left, root);
        
        if(root.right != null)
            map.put(root.right, root);
        
        mapParent(root.left, map);
        mapParent(root.right, map);
    }
}
