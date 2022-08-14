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
    
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;
        
        // Based on Morris tree Traversal
        TreeNode prev = null;
        
        while(curr != null){
            
            if(curr.left != null) {
                prev = curr.left; // save left subtree of curr node which will be used to reach left subtree later
                
                while(prev.right != null)
                    prev = prev.right;
                
                prev.right = curr.right; // first connect right subtree's rightmost node of curr node to the left of its
                curr.right = curr.left; // connect curr nodes right to its left subtree
                
                curr.left = null; // make left node points to null
            }
            
            curr = curr.right;
        }
    }
}
