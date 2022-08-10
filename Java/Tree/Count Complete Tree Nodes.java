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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = countLeftHeight(root);
        int right = countRightHeight(root);
        
        if(left == right)
            return ((2<<(left)) - 1); // 2^left - 1
        
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int countLeftHeight(TreeNode root) {
        int height = 0;
        
        while(root.left != null) {
            root = root.left;
            height++;
        }
        
        return height;
    }
    
     private int countRightHeight(TreeNode root) {
        int height = 0;
        
        while(root.right != null) {
            root = root.right;
            height++;
        }
        
        return height;
    }
}
