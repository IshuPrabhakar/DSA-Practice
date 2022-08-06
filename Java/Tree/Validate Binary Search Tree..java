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
    public boolean isValidBST(TreeNode root) {
        TreeNode previousNode = null;
        
        if(root == null)
            return true;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(true) {
            
            if(root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                if(stack.isEmpty())
                    break;
                
                root = stack.pop();
                if(previousNode != null && root.val <= previousNode.val) // in inorder traversal previos node that is left node is less than the root node 
                    return false;

                previousNode = root;
                root = root.right;
            }
        }
        
        return true;
    }
}
