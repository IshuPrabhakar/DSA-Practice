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
    int MaxSum;
    public int maxPathSum(TreeNode root) {
        MaxSum = Integer.MIN_VALUE;
        
        dfs(root);
        
        return MaxSum;
    }
    
    private int dfs(TreeNode root) {
        if(root == null)
            return 0;
        
        int left_sum = Math.max(0, dfs(root.left)); // by doing this we are ignoring negative values which cannot give us max path sum
        int right_sum =  Math.max(0, dfs(root.right));
        
        MaxSum = Math.max(MaxSum, root.val + left_sum + right_sum);
        
        return root.val + Math.max(left_sum, right_sum);
    }
}
