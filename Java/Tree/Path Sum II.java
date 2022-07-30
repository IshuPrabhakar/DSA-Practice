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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // Resultan list
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(root, targetSum, result, new ArrayList<>());
        
        return result;
    }
    
    private void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> currpath) {
        // Base case
        if(root == null)
            return ;

        currpath.add(root.val);
        
        if(root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(currpath));
            currpath.remove(currpath.size() - 1);
            return;
        }
        
        dfs(root.left, targetSum - root.val, result, currpath);
        dfs(root.right, targetSum - root.val, result, currpath);
        
        currpath.remove(currpath.size() - 1);
    }
}
