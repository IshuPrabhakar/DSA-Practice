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
    
    private int leftMost;
    
    // this can be somewhat optimised by making maxDepth variable local by passing it with
    // the recursive function call 
    
    // NOTE: at each level in function call value get changed in one level value is something
    // at next level value gets updated. After finishing the funtion call value reverts back 
    // to its previous value.
    
    // When value is directly passed like int maxdepth etc.
    // to overcome this use global variable or refrence type variable like list, array, maps etc.
    
    private int maxDepth = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null)
            return root.val;

        
        // There are two approaches for this
        // 1: DFS
        // 2: BFS 
        preOrder(root, 0);
        
        return leftMost;
    }
    
    private void preOrder(TreeNode root, int currDepth){
        if(root != null) {
            if(currDepth > maxDepth) {
                leftMost = root.val;
                maxDepth = currDepth;
            }
        }
        
        if(root.left != null)
            preOrder(root.left, currDepth + 1);
        
        if(root.right != null)
            preOrder(root.right, currDepth + 1);
    }
}
