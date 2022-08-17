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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }
    
    private TreeNode buildTree(int left, int right, int[] nums) {
        if(left > right)
            return null;
        
        int mid = left + (right - left)/2; // mid will be our root
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = buildTree(left, mid - 1, nums); // building left and right sub tree
        root.right = buildTree(mid + 1, right, nums);
        
        // As array is sorted we need not to check wheather to insert its child
        //
        
        return root;
    }
}
