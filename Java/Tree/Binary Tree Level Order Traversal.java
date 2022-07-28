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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Resultant list
        List<List<Integer>> result = new ArrayList<>();
        
        // Edge case
        if(root == null)
            return result;
        
        // Queue
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int curr_size = q.size();
            List<Integer> level_list = new ArrayList<>();
            
            for(int i = 0; i < curr_size; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                
                // Adding nodes value into the list
                level_list.add(q.poll().val);
            }
            result.add(level_list);
        }
        
        return result;
    }
}
