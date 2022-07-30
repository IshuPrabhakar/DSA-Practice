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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Resultant list
        LinkedList<List<Integer>> result = new LinkedList<>();
        
        // Edge case
        if(root == null)
            return result;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int level_num = q.size();
            List<Integer> levelNode = new ArrayList<>();
            
            for(int i = 0; i < level_num; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                
                levelNode.add(q.poll().val);
            }
            // since we can insert at front of linkedlist in O(1) time
            result.addFirst(new ArrayList<>(levelNode));
        }
        
        return result;
    }
}
