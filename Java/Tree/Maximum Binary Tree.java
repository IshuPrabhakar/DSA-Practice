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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        // TC => O(NlogN)
        // SC => O(N)
        if(nums.length == 0)
            return null;
        
        return buildTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end)
            return null;
        
        int max_index = start;
        for(int i = start; i <= end; i++){
            if(nums[i] > nums[max_index])
                max_index = i;
        }
        
        // Simply it is preOrder traversal
        // create a new node
        TreeNode root = new TreeNode(nums[max_index]);
        
        // Build left and right tree 
        root.left = buildTree(nums, start, max_index - 1);
        root.right = buildTree(nums, max_index + 1, end);
        
        return root;
    }
}
