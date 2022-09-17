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
class BSTIterator {
    
    private ArrayDeque<TreeNode> stack;
    private TreeNode root;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        this.root = root;
    }
    
    public int next() {
        // Simple inorder traversal
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
        TreeNode next = stack.pop();
        root = next.right;
        
        return next.val;
    }
    
    public boolean hasNext() {
       return root != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
