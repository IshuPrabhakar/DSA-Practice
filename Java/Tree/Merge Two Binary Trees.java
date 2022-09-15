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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        //We can traverse both the given trees in a preorder fashion. At every
        //step, we check if the current node exists(isn't null) for both the
        //trees. If so, we add the values in the current nodes of both the trees
        //and update the value in the current node of the first tree to reflect
        //this sum obtained. At every step, we also call the original function
        //mergeTrees() with the left children and then with the right children of
        //the current nodes of the two trees. If at any step, one of these
        //children happens to be null, we return the child of the other
        //tree(representing the corresponding child subtree) to be added as a
        //child subtree to the calling parent node in the first tree.
      
        // Time complexity : O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
        // Space complexity : O(m). The depth of the recursion tree can go upto m in the case of a skewed tree. In average case, depth will be O(logm).
        
        if(root1 == null)
            return root2;
        
        if(root2 == null)
            return root1;
        
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;
    }
}
