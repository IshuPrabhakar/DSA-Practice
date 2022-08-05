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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        
        if (root == null)
            return maxWidth;
        
        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));
        
        while(!q.isEmpty()) {
            int curr_size = q.size();
            int min = q.peek().getValue(); // min will always be at the first
            int first = 0, last = 0;
            
            for(int i = 0; i < curr_size; i++) {
                
                int curr_id = q.peek().getValue() - min; // substract new index with the minimum of previous level to avoid overflow
                TreeNode node = q.peek().getKey();
                q.poll();
                
                if(i == 0) first = curr_id;
                if(i == curr_size - 1) last = curr_id;

                if(node.left != null) 
                    q.offer(new Pair<>(node.left, curr_id * 2 + 1)); // 2*i + 1
                if(node.right != null) 
                    q.offer(new Pair<>(node.right, curr_id * 2 + 2)); // 2*i + 2
            }
            
            maxWidth = Math.max(last - first + 1, maxWidth);
        }
        
        return maxWidth;
    }
}
