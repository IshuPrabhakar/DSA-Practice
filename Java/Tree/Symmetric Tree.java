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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return false;
        
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode subtree1,TreeNode subtree2) {
        
        if(subtree1 == null || subtree2 == null)
            return subtree1 == subtree2;
        
        if(subtree1.val != subtree2.val)
            return false;
        
        // if subtree1.val == subtree1.val then
        return isMirror(subtree1.left, subtree2.right) && isMirror(subtree1.right, subtree2.left);
    } 
}
