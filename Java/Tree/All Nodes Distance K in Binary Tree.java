/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        // Create Node - Parent mapping
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        mapNodeToParent(root, map);
        
        // Implement BFS
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> visitedSet = new HashSet<>();
        
        q.offer(target);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                visitedSet.add(curr);
                
                if(k == 0)
                    result.add(curr.val);
                
                if(map.containsKey(curr) && !visitedSet.contains(map.get(curr)))
                    q.offer(map.get(curr));
                
                if(curr.left != null && !visitedSet.contains(curr.left))
                    q.offer(curr.left);
                
                if(curr.right != null && !visitedSet.contains(curr.right))
                    q.offer(curr.right);
            }
            
            k--;
            if(k < 0) break;
        }
        
        return result;
    }
    
    private void mapNodeToParent(TreeNode root, HashMap<TreeNode, TreeNode> map) {
        
        if(root == null)
            return;
        
        // if root.left is not null then root is become the parent of root.left node
        if(root.left != null)
            map.put(root.left, root);
        
         // if root.right is not null then root is become the parent of root.right node
        if(root.right != null)
            map.put(root.right, root);
        
        mapNodeToParent(root.left, map);
        mapNodeToParent(root.right, map);
    }
}
