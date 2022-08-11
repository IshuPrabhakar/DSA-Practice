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
    
    private int postIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        postIndex = length - 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // hashing inorder
        for(int i = 0; i < length; i++)
            map.put(inorder[i], i);
            
        return ConstructTree(inorder, postorder, 0, length - 1, length, map);
    }
    
    private TreeNode ConstructTree(int[] inorder, int[] postorder, int inStart, int inEnd, int length, HashMap<Integer, Integer> map) {
        if(postIndex < 0 || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postIndex--]); // root
        int position = map.get(root.val);
        
        // In case of post order Left, Right, Root so first call for root, then right, and left
        root.right = ConstructTree(inorder, postorder, position + 1, inEnd, length, map); // right
        root.left = ConstructTree(inorder, postorder, inStart, position - 1, length, map); // left
        
        return root;
    }
}
