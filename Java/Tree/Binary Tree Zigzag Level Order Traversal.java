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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // direction variable
        boolean isRightToLeft = false;
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int nodesCountAtLevel = q.size();
            
            LinkedList<Integer> curr = new LinkedList<>();
            
            for(int i = 0; i < nodesCountAtLevel; i++) {
                
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                
                if (isRightToLeft) 
                    curr.addFirst(q.poll().val);
                else 
                    curr.add(q.poll().val);
            }
            
            result.add(curr);
            isRightToLeft = !isRightToLeft; // alter sign after if true then false if false then true
        }
        
        return result;
    }
}
