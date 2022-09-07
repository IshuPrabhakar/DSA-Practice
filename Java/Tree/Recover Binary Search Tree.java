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
    
    private TreeNode prevNode = null;
    private TreeNode firstNode = null;
    private TreeNode secondNode = null;
    
    public void recoverTree(TreeNode root) {
        
        if(root == null)
            return;
        
        inorder(root);
        
        // Swapping the values
        int valToChange = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = valToChange;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return ;
        
        inorder(root.left);
        
        // this will keep the first decreasing sequence
        if(firstNode == null && prevNode != null && prevNode.val >= root.val)
            firstNode = prevNode;
        
        // this will keep the second decreasing sequence
        if(firstNode != null && prevNode.val >= root.val)
            secondNode = root;
        
        prevNode = root;
        
        inorder(root.right);
    }
}
