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
    public int goodNodes(TreeNode root) {
        // Approach is to use Preorder traversal although it can be implemented using
        // any dfs traversal. Idea is that, if node is Good then count it as 1 else 0
        // similarly make recursive call for left and right subtree. and return result.
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs(TreeNode root, int max){
        if(root == null)
            return 0;
        
        int count = (root.val >= max) ? 1 : 0;
        
        count += dfs(root.left, Math.max(root.val, max));
        count += dfs(root.right, Math.max(root.val, max));
            
        return count;
    }
}
