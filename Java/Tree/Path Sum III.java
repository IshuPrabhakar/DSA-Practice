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
 *  TC: O(n)
 *  SC: O(n);
 */
class Solution {
    
    int NumberOfPaths = 0;
    public int pathSum(TreeNode root, int targetSum) {
        
        // Approach is to use a hashmap to store the previous values
        // which ensures that if we had previously visited that node
        // that makes our sum equal to the target sum. so essentially we
        // are checking if there is a node whose can be removed from the path 
        // which makes our sum == target if yes then increase count.
        
        // NOTE: Root can have value out of range of integer causing overflow
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // for checking if does root makes equal to the target sum
        map.put(0, 1);
        
        dfs(root, targetSum, map, 0);
        
        return NumberOfPaths;
    }
    
    private void dfs(TreeNode root, int targetSum, HashMap<Integer, Integer> map, int currSum) {
        if(root == null)
            return;
        
        currSum = (currSum%1000000007 + root.val%1000000007)%1000000007;
        
        if(map.containsKey(currSum - targetSum)) {
            NumberOfPaths += map.get(currSum - targetSum);
        }
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        dfs(root.left, targetSum, map, currSum);
        dfs(root.right, targetSum, map, currSum);
        
        map.put(currSum, map.get(currSum) - 1); // decreasing the variable frequency

    }
}
