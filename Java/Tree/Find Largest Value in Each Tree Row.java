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
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null)
            return new ArrayList<Integer>();
        
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            int max_at_curr_level = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                
                max_at_curr_level = Math.max(max_at_curr_level, curr.val);

            }
            
            result.add(max_at_curr_level);
        }
        
        return result;
    }
}
