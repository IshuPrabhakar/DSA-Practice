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
    
    private TreeNode previous = null;
    
    public void flatten(TreeNode root) {
        
        // Base case
        if(root == null)
            return ;
        
        flatten(root.right); // first go to right and this right will be used as previous
        flatten(root.left);
        
        root.right = previous; // set current node right to previous
        root.left = null; // Set current nodes left to null
        
        previous = root; // update previous
    }
}
