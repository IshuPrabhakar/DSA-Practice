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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return null;

        if(root.val == key)
            return delete(root);
        
        TreeNode dummy = root;
        
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = delete(root.left);
                    break;
                }
                else
                    root = root.left;
            }
            else{
                 if(root.right != null && root.right.val == key){
                    root.right = delete(root.right);
                    break;
                }
                else
                    root = root.right;
            }
        }
        
        return dummy;
    }
    
    private TreeNode delete(TreeNode root){
        if(root.left == null)
            return root.right;
        
        if(root.right == null)
            return root.left;
        
        // go right and find the min value connect it with root.left and return root.right
        TreeNode temp = root.left;
        TreeNode lastNode = findMin(root.right);
        lastNode.left = temp;
        
        return root.right;
    }
    
    private TreeNode findMin(TreeNode root) {
        
        while(root.left != null)
            root = root.left;
        
        return root;
    }
}
