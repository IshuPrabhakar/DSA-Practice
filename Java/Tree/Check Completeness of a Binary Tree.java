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
    public boolean isCompleteTree(TreeNode root) {
        
        // Approach is to use level order traversal 
        // as it will process node from left to right then we can easily know
        // if tree is complete or not
        if(root == null)
            return true;
        
        boolean isleftNull = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if(curr == null) 
                isleftNull = true;
            else{
                if(isleftNull) 
                    return false;
                
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        
        return true;
    }
}
