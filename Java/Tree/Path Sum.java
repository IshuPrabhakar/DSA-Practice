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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return dfs(root, targetSum);
    }
    
    private boolean dfs(TreeNode root, int targetSum) {
        
        // Base case
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null)
            return targetSum - root.val == 0;
        
        // Since it is a binary tree we can either go left or right only
        boolean left = dfs(root.left, targetSum - root.val);
        boolean right = dfs(root.right, targetSum - root.val);
        
        // if any path lead to target sum
        return left || right;
    }
}
