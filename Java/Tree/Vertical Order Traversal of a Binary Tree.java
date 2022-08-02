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
    // class to store nodes value along with their cordinates
    class Node{
        int row;
        int col;
        TreeNode node;
        
        public Node(int x, int y, TreeNode node){
            this.row = x;
            this.col = y;
            this.node = node;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // Edge case
        if(root == null)
            return new ArrayList<>();
        
        // iterate over the tree to get all nodes along with their cordinates
        List<Node> list = new ArrayList<>();
        inOrderTraversal(root, list, 0, 0);
        
        // if Nodes are at same level i.e. their x and y values are same then
        // they should be ordered according to their nodes value
        // else level wise i.e. top to bottom order
        // n1.row == n2.row ? n1.col == n2.col ? n1.val - n2.val : n2.col - n1.col : n1.row - n2.row
        Collections.sort(list, (n1, n2) -> n1.row == n2.row ? n1.col == n2.col ? n1.node.val - n2.node.val : n2.col - n1.col : n1.row - n2.row);
        
        // create a treemap , tree map because it will maintain the sorted order
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        for(Node node : list) {
            List<Integer> values = map.getOrDefault(node.row, new ArrayList<>());
            values.add(node.node.val);
            map.put(node.row, values);
        }
        
        // prepare result
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> l : map.values()) {
            result.add(l);
        }
        
        return result;
    }
    
    private void inOrderTraversal(TreeNode root, List<Node> list, int x, int y) {
        if(root == null)
            return;
        
        // Since root is at (0,0)
        inOrderTraversal(root.left, list, x - 1, y - 1);
        list.add(new Node(x, y, root));
        inOrderTraversal(root.right, list, x + 1, y - 1);
    }
}
