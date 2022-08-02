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
    public List<Integer> rightSideView(TreeNode root) {
        //      1
        //     / \
        //    2   5
        //   /
        //  3
        // ans will be 1,5,3
        // This is Your edge case
        List<Integer> result = new ArrayList<>();
        
        rightView(root, result, 0);
        
        return result;
    }
    
    private void rightView(TreeNode root, List<Integer> result, int currLevel) {
        if(root == null)
            return ;
        
        if(result.size() == currLevel)
            result.add(root.val); // Ensure to add only one node at each level 
        
        rightView(root.right, result, currLevel + 1);
        rightView(root.left, result, currLevel + 1);
    }
}
