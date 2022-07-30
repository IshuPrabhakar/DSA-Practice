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
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        
        int[] diameter = new int[1];
        
        height(root, diameter);
        
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null)
            return 0;
        
        int left_height = height(node.left, diameter);
        int right_height = height(node.right, diameter);
        
        diameter[0] = Math.max(diameter[0], left_height + right_height);
        
        return 1 + Math.max(left_height, right_height);
    }
}
