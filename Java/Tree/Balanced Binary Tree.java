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
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        if(height(root) == -1)
            return false;
        
        return true;
    }
    
    private int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int left_Height = height(root.left);
        int right_Height = height(root.right);
        
        // check for balancing
         if(left_Height == -1 || right_Height == -1)
            return -1;
        
        if(Math.abs(left_Height - right_Height) > 1)
            return -1;
       
        return Math.max(left_Height, right_Height) + 1;
    }
}
