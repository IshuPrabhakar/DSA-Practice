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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> result = new ArrayList<>();
        if(root != null)
            dfs(root, result, "");
        
        return result;
    }
    
    private void dfs(TreeNode root, List<String> result, String path){
        if(root.left == null && root.right == null){
            result.add(path + root.val);
            return ;
        }
        
        if(root.left != null)
            dfs(root.left, result, path + root.val + "->");
        
        if(root.right != null)
            dfs(root.right, result, path + root.val + "->");
    }
}
