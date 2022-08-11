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
    
    private int preIndex; // this should be global otherwise it will change during the function call
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // There are two simple solution with different time complexities
        // TC => O(logh * N), SC => O(1)
        // TC => O(logh), SC => O(N), h = height of the tree
        preIndex = 0;
        int length = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Hash inorder
        for(int i = 0; i < length; i++){
            map.put(inorder[i], i);
        }
        
        return ConstructTree(preorder, inorder, 0, length - 1, length, map);
    }
    
    private TreeNode ConstructTree(int[] preorder, int[] inorder, int inStart, int inEnd, int n, HashMap<Integer, Integer> map) {
        
        // Base case
        if(preIndex >= n || inStart > inEnd) // if we covered all index in preorder
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int inIndex = map.get(root.val); // Index of current root in inorder
        
        root.left = ConstructTree(preorder, inorder, inStart, inIndex - 1, n, map); // left call
        root.right = ConstructTree(preorder, inorder, inIndex + 1, inEnd, n, map); // right call
        
        return root;
    }
}
