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
    public int kthSmallest(TreeNode root, int k) {
        // Kth smallest element is the element that we get after arranging all the elements in sorted order
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(true) {
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty())
                    break;
                root = stack.pop();
                
                if(--k == 0)
                    return root.val;
                
                root = root.right;
            }
        }
        
        return root.val;
    }
}
