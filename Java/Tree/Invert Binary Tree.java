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
    public TreeNode invertTree(TreeNode root) {
        
        // there can be many solution to this problem
        // easyone would be recursive solution but to avoid 
        // stack overflow and time consume by recursion we can
        // use any other traversal like BFS or DFS
        
        if(root == null)
            return null;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            
            TreeNode node = q.poll();
            
            TreeNode leftNode = node.left; // change left to right
            node.left = node.right; /// and right to left
            node.right = leftNode;
            
            if(node.left != null)
                q.offer(node.left);
            
            if(node.right != null)
                q.offer(node.right);
        }
        
        return root;
    }
}
